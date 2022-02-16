package sword_to_offer.t0216.fu_za_lian_biao_de_fu_zhi_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * 剑指 Offer 35. 复杂链表的复制
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[][] head = {{7,null},{13,0},{11,4},{10,2},{1,0}};


    }

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
