package sword_to_offer.t0217.bao_han_minhan_shu_de_zhan_lcof;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * 剑指 Offer 30. 包含min函数的栈
 * 简单
 *
 * @author liulin
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }

    Stack<Integer> numStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        numStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        numStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        numStack.pop();
        minStack.pop();
    }

    public int top() {
        return numStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
