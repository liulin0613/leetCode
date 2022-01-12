package hot_100.t0107.sort_list;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import static hot_100.t0107.insertion_sort_list.Main.insertionSortList;

/**
 * https://leetcode-cn.com/problems/sort-list/
 *
 * 148. 排序链表
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{4,2,1,3,5};
        ListNode head = ListNodeUtils.generateListNode(nodes);
        ListNodeUtils.iteratorListNode(head);
        ListNodeUtils.iteratorListNode(sortList2(head));
    }

    /**
     * 使用 插入排序
     * o(n^2) o(1)
     *
     * 652 ms  8.00%  42.8 MB  97.38%
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        return insertionSortList(head);
    }


    /**
     * 归并排序
     * o(nlogn) o(logn)
     *
     * 5 ms 98.96%   46.7 MB  55.48%
     *
     * @param head
     * @return
     */
    private static ListNode sortList2(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;

        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);

        return merge(l, r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while (l != null && r != null){
            if(l.val > r.val){
                pre.next = r;
                r = r.next;
            }else {
                pre.next = l;
                l = l.next;
            }

            pre = pre.next;
        }

        pre.next = l == null ? r : l;

        return head.next;
    }
}
