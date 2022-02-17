package sword_to_offer.t0217.zhan_de_ya_ru_dan_chu_xu_lie_lcof;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 *
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};

        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int value : pushed) {
            stack.push(value);

            while (!stack.isEmpty() && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }

        return stack.isEmpty();
    }
}
