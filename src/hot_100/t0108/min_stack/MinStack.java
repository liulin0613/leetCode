package hot_100.t0108.min_stack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/min-stack/
 *
 * 155. 最小栈
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
        System.out.println(minStack.getMin());;   // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());;      // --> 返回 0.
        System.out.println(minStack.getMin());;   // --> 返回 -2.

    }



    private final int INIT_SIZE = 100;

    private int[] elements;
    private int size;
    private int min;    /* 维护一个最小值 */
    private int minCount;


    public MinStack() {
        elements = new int[INIT_SIZE];
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ensureCapacity();       /* 扩容检测 */
        elements[size++] = x;
        /* 维护最小值 */
        if(x < min) {
            min = x;
            minCount = 1;
        } else if(x == min) {
            minCount++;
        }
    }

    public void pop() {
        int popNum = elements[--size]; /* 被删除的数 */
        /* 维护最小值 */
        if(popNum == min && --minCount == 0) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(min, elements[i]);
            }
            minCount = 1;
        }
    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;  /* 直接返回最小值 */
    }

    /**
     * 是否需要扩容
     */
    private void ensureCapacity() {
        if(size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }
}
