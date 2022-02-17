package sword_to_offer.t0217.shu_ju_liu_zhong_de_zhong_wei_shu_lcof;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 *
 * 剑指 Offer 41. 数据流中的中位数
 * 困难
 *
 * @author liulin
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }

    ListNode head;
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        head = new ListNode(-1);
        size = 0;
    }

    public void addNum(int num) {
        ListNode ptr = head;
        while (ptr.next != null && ptr.next.val < num){
            ptr = ptr.next;
        }

        ListNode temp = ptr.next;
        ptr.next = new ListNode(num);
        ptr.next.next = temp;

        size++;
    }

    public double findMedian() {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(size % 2 == 0){
            return (slow.val + slow.next.val) / 2.;
        }else {
            return slow.val;
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val,ListNode next) {this.val = val;this.next = next; }
}
