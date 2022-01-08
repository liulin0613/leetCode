package t0108.reverse_linked_list;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 206. 反转链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes =  new int[]{1,2,3,4,5};
        ListNode head = ListNodeUtils.generateListNode(nodes);

        ListNodeUtils.iteratorListNode(head);
        ListNodeUtils.iteratorListNode(reverseList(head));
    }

    /**
     * 头插法
     * @param head
     * @return
     */
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
