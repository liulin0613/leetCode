package hot_100.t0107.linked_list_cycle_ii;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * 142. 环形链表 II
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nodes = new int[]{3,2,0,-4};
        int pos = 1;

        ListNode head = ListNodeUtils.generateListNode(nodes);
        ListNodeUtils.generateCycle(head,pos);

        System.out.println(detectCycle2(head));
    }

    /**
     * 通过 HashSet 存储
     * 时间复杂度 O(n)，空间复杂度 O(n)
     * 4 ms 12.10%  39.3 MB 11.60%
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head!=null){
            if(set.contains(head)){
                return head;
            }

            set.add(head);
            head = head.next;
        }

        return null;
    }

    /**
     * 快慢指针  0 ms  100.00%  38.5 MB 45.60%
     *
     * 如图 ： 1641540736.jpg
     *
     * fast 走过的总距离为  a+n(b+c)+b = a+(n+1)b+nca+n(b+c)+b = a+(n+1)b+nc
     * 任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍
     * a+(n+1)b+nc = 2(a+b)    ⟹ a=c+(n−1)(b+c)
     * 从相遇点到入环点的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离
     *  ==> (ptr 从头开始走一定能和 slow 在入环处遇到)
     *
     * @param head
     * @return
     */
    private static ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast =head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                ListNode ptr = head;
                while (slow != ptr){
                    slow = slow.next;
                    ptr = ptr.next;
                }

                return ptr;
            }
        }

        return null;
    }
}
