package hot_100.t0107.insertion_sort_list;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * 147. 对链表进行插入排序
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{4,2,1,3};
        ListNode head = ListNodeUtils.generateListNode(nodes);

        ListNodeUtils.iteratorListNode(head);
        ListNodeUtils.iteratorListNode(insertionSortList(head));
    }

    /**
     * 2 ms 99.17%  38.2 MB 22.93%
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode lastSorted = head, curr = head.next;
        while (curr != null){
            if(lastSorted.val <= curr.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummyHead;
                while (pre.next.val <= curr.val){
                    pre = pre.next;
                }

                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }

            curr = lastSorted.next;
        }

        return dummyHead.next;
    }
}
