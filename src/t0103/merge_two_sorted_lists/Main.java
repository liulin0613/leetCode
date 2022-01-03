package t0103.merge_two_sorted_lists;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 21. 合并两个有序链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] l1 = new int[]{};
        int[] l2 = new int[]{0};
        ListNode list1 = ListNodeUtils.generateListNode(l1);
        ListNode list2 = ListNodeUtils.generateListNode(l2);
        ListNodeUtils.iteratorListNode(mergeTwoLists(list1,list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1!=null || list2!=null){
            if(list1 == null){
                head.next = list2;
                list2=list2.next;
            }else if(list2 == null){
                head.next = list1;
                list1=list1.next;
            }else if(list1.val<list2.val){
                head.next= list1;
                list1=list1.next;
            }else {
                head.next=list2;
                list2=list2.next;
            }

            head = head.next;
        }

        return p.next;
    }
}
