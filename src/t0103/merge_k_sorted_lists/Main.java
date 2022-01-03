package t0103.merge_k_sorted_lists;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 23. 合并 K 个升序链表
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1,4,5),
                Arrays.asList(1,3,4),
                Arrays.asList(2,6)
        );

        ListNode[] listNodes = new ListNode[lists.size()];
        int k=0;
        for (List<Integer> list : lists) {
            int[] arr = new int[list.size()];
            int index = 0;
            for (Integer integer : list) {
                arr[index++]= integer;
            }

            listNodes[k++] = ListNodeUtils.generateListNode(arr);
        }

        ListNodeUtils.iteratorListNode(mergeKLists2(listNodes));
    }

    /**
     * 顺序合并的方法 time 99ms  memory 40.4 M
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for (ListNode list : lists) {
            head = mergeTwoList(head, list);
        }

        return head;
    }

    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cp = head;

        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                cp.next = list1;
                list1 = list1.next;
            }else {
                cp.next = list2;
                list2 = list2.next;
            }

            cp = cp.next;
        }

        cp.next = list1==null?list2:list1;

        return head.next;
    }


    /**
     * 使用优先级队列 time 9ms  memory 40.3 M
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if(list!=null){
                pq.offer(list);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            if(cur.next!=null){
                pq.offer(cur.next);
            }
        }

        return head.next;
    }

}
