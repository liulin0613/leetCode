package sword_to_offer.t0216.lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5};
        int k = 3;

        ListNode head = ListNodeUtils.generateListNode(nodes);

        ListNodeUtils.iteratorListNode(getKthFromEnd(head,k));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 1; i < k; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
