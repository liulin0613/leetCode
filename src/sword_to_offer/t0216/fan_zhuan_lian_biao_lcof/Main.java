package sword_to_offer.t0216.fan_zhuan_lian_biao_lcof;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * 剑指 Offer 24. 反转链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5};

        ListNode head = ListNodeUtils.generateListNode(nodes);

        ListNodeUtils.iteratorListNode(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);

        while (head != null){
            ListNode node = head;
            head = head.next;
            node.next = newHead.next;
            newHead.next = node;
        }

        return newHead.next;
    }
}
