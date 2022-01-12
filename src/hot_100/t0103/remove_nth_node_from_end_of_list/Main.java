package hot_100.t0103.remove_nth_node_from_end_of_list;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 19. 删除链表的倒数第 N 个结点
 * 中等
 *
 * @author liulin
 */

public class Main {

    public static void main(String[] args) {
        int[] h = new int[]{1,2};
        int n =2;

        ListNode head = ListNodeUtils.generateListNode(h);
        ListNodeUtils.iteratorListNode(head);
        ListNodeUtils.iteratorListNode(removeNthFromEnd(head, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode front = head;

        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        if(pre == null) return front.next;

        while (pre.next!=null){
            pre = pre.next;
            front=front.next;
        }

        front.next = front.next.next;

        return head;
    }

}
