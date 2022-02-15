package sword_to_offer.t0215.he_bing_liang_ge_pai_xu_de_lian_biao_lco;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;


/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] node1 = new int[]{1,2,4};
        int[] node2 = new int[]{1,3,4};

        ListNode l1 = ListNodeUtils.generateListNode(node1);
        ListNode l2 = ListNodeUtils.generateListNode(node2);

        ListNodeUtils.iteratorListNode(mergeTwoLists(l1,l2));


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode head = dummy;

        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                dummy.next = l2;
                l2 = l2.next;
            }else {
                dummy.next = l1;
                l1 = l1.next;
            }

            dummy = dummy.next;
        }

        dummy.next = l1 != null ? l1 : l2;

        return head.next;
    }

}
