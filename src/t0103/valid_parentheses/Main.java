package t0103.valid_parentheses;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 20. 有效的括号
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar == ')'){
                if(stack.empty() || stack.pop() != '(') return false;
            }else if(aChar == ']'){
                if(stack.empty() || stack.pop() != '[') return false;
            }
            else if(aChar == '}'){
                if(stack.empty() || stack.pop() != '{') return false;
            }else {
                stack.push(aChar);
            }
        }

        return stack.empty();
    }
}
