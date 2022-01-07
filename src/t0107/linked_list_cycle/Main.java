package t0107.linked_list_cycle;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 141. 环形链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{1,2};
        int pos = -1;

        ListNode head = ListNodeUtils.generateListNode(nodes);
        ListNodeUtils.generateCycle(head,pos);

        System.out.println(hasCycle(head));
    }

    /**
     * 快慢指针判断是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow!=null && fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
