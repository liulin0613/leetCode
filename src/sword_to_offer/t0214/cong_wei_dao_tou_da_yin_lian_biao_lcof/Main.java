package sword_to_offer.t0214.cong_wei_dao_tou_da_yin_lian_biao_lcof;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{1,3,2,3,4,5,6,7,8,9};
        ListNode head = ListNodeUtils.generateListNode(nodes);

        System.out.println(Arrays.toString(reversePrint(head)));
    }

    public static int[] reversePrint(ListNode head) {
        ListNode dummy = new ListNode(-1);
        int len = reverseList(head,dummy);

        int[] res = new int[len];
        dummy = dummy.next;

        int index = 0;
        while (dummy != null){
            res[index++] = dummy.val;
            dummy = dummy.next;
        }
        return res;
    }

    private static int reverseList(ListNode head, ListNode dummy) {
        int count=0;
        while (head != null){
            ListNode temp = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = temp;

            count++;
        }
        return count;
    }
}
