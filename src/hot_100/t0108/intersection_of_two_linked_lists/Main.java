package hot_100.t0108.intersection_of_two_linked_lists;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import java.util.HashSet;

import static utils.list_node.ListNodeUtils.generateIntersectionList;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 160. 相交链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] listA = new int[]{1,9,1,2,4};
        int[] listB = new int[]{3,2,4};
        int skipA = 3, skipB = 1;

        ListNode[] lists= generateIntersectionList(listA,listB,skipA,skipB);
        ListNode headA = lists[0];
        ListNode headB = lists[1];

        ListNodeUtils.iteratorListNode(headA);
        ListNodeUtils.iteratorListNode(headB);

        ListNodeUtils.iteratorListNode(getIntersectionNode(headA,headB));
        ListNodeUtils.iteratorListNode(getIntersectionNode2(headA,headB));

    }

    /**
     * HashSet
     * 7 ms 25.33%  42.3 MB  7.83%
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode ptr = headA;
        while (ptr != null){
            set.add(ptr);
            ptr = ptr.next;
        }

        ListNode ptr2 = headB;
        while (ptr2 != null){
            if(set.contains(ptr2)){
                return ptr2;
            }

            ptr2 = ptr2.next;
        }

        return null;
    }


    /**
     * 双指针
     * 1 ms  99.98%  41.1 MB  76.31%
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while (ptr1 != ptr2){
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }

        return ptr1;
    }
}
