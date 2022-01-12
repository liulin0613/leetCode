package hot_100.t0104.longest_valid_parentheses;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * 32. 最长有效括号
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxAns = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
                dp[i] = i-2>=0 ? dp[i-2] + 2 : 2;
                maxAns = Math.max(dp[i],maxAns);

            }else if(s.charAt(i) == ')' && s.charAt(i-1) == ')'){
                if(i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '('){
                    dp[i] = i-2-dp[i-1] >= 0 ? dp[i-2-dp[i-1]] + dp[i-1] + 2 : dp[i-1] + 2;
                    maxAns = Math.max(dp[i],maxAns);
                }
            }
        }
        return maxAns;
    }


    /**
     * stack --> 不行
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int count = 0;
        int max = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar == '('){
                stack.push(aChar);
            }else {
                if(stack.isEmpty()){
                    max = Math.max(max,count);
                    count = 0;
                    continue;
                }

                stack.pop();
                count+=2;
            }
        }

        return Math.max(max,count);
    }
}
