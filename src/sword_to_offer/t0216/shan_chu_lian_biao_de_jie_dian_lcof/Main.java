package sword_to_offer.t0216.shan_chu_lian_biao_de_jie_dian_lcof;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * 剑指 Offer 18. 删除链表的节点
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = {4,5,1,9};
        int val = 4;

        ListNode head = ListNodeUtils.generateListNode(nodes);

        ListNodeUtils.iteratorListNode(deleteNode(head,val));
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }

        if(head.val == val) return head.next;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null){
            if(fast.val == val){
                slow.next = fast.next;
                break;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return head;
    }
}
