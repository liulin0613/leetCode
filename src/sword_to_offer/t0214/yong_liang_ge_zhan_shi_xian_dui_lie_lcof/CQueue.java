package sword_to_offer.t0214.yong_liang_ge_zhan_shi_xian_dui_lie_lcof;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * 剑指 Offer 09. 用两个栈实现队列
 * 简单
 *
 * @author liulin
 */
class CQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {

        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            return -1;
        } else {
            return s2.pop();
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
