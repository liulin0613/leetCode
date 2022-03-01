package sword_to_offer.t0301.liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] node1 = {4,1,8,4,5};
        int[] node2 = {5,0,1,8,4,5};

        ListNode[] listNodes = ListNodeUtils.generateIntersectionList(node1, node2, 2, 3);

        System.out.println(getIntersectionNode(listNodes[0], listNodes[1]).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB){
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }

        return ptrA;
    }
}
