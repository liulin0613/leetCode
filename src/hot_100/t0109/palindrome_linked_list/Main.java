package hot_100.t0109.palindrome_linked_list;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 234. 回文链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{1,2,2,1};
        ListNode head = ListNodeUtils.generateListNode(nodes);

        System.out.println(isPalindrome(head));
    }

    /**
     * 翻转链表  --> 进阶：只需要翻转后半部分，与前半部分比较，空间复杂度 O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = head;

        while (newHead != null){
            ListNode node = new ListNode(newHead.val);
            newHead = newHead.next;
            node.next = dummy.next;
            dummy.next = node;
        }

        dummy = dummy.next;
        while (dummy != null){
            if(dummy.val != head.val){
                return false;
            }

            dummy = dummy.next;
            head = head.next;
        }

        return true;
    }
}
