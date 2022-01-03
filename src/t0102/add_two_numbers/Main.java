package t0102.add_two_numbers;

import utils.list_node.ListNode;
import utils.list_node.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 2. 两数相加
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int [] arr1 = new int[]{9,9,9,9,9,9,9};
        int [] arr2 = new int[]{9,9,9,9};
        ListNode l1 = ListNodeUtils.generateListNode(arr1);
        ListNode l2 = ListNodeUtils.generateListNode(arr2);
        ListNodeUtils.iteratorListNode(addTwoNumbers(l1,l2));
        ListNodeUtils.iteratorListNode(addTwoNumbers2(l1,l2));
    }



    /**
     * 个人题解
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean hasUp = false;
        List<Integer> list = new ArrayList<>();

        while (l1!=null || l2!=null){
            int num1 = l1!=null? l1.val:0;
            int num2 = l2!=null? l2.val:0;
            int up = hasUp?1:0;

            int res = num1+num2;
            if(res >= 10){
                list.add(res - 10 + up);
                hasUp = true;
            }else {
                if(res+up >= 10){
                    list.add(res - 10 + up);
                    hasUp = true;
                }else {
                    list.add(res+up);
                    hasUp=false;
                }
            }

            if(l1!=null)
                l1=l1.next;

            if(l2!=null)
                l2 =l2.next;
        }

        if(hasUp){
            list.add(1);
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            result[index++] = integer;
        }

        return ListNodeUtils.generateListNode(result);
    }

    /**
     * 官方题解
     * @param
     * @return
     */
    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode next = null;

        int carry = 0;

        while (l1!=null || l2!=null){
            int num1 = l1!=null? l1.val:0;
            int num2 = l2!=null? l2.val:0;
            int sum = num1 + num2 + carry;

            if(head == null){
                head = new ListNode(sum % 10);
                next = head;
            }else {
                next.next = new ListNode(sum % 10);
                next=next.next;
            }

            carry = sum / 10;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }

        if(carry != 0){
            next.next = new ListNode(carry % 10);
        }

        return head;
    }

}
