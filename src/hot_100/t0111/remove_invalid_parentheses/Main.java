package hot_100.t0111.remove_invalid_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 *
 * 301. 删除无效的括号
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = ")d))";

        System.out.println(removeInvalidParentheses(s));
    }

    private static List<String> res = new ArrayList<>();

    public static List<String> removeInvalidParentheses(String s) {

        int[] c = mustDeleteParenthesesCount(s);
        int lRemove = c[0];
        int rRemove = c[1];

        backtrack(s,0,lRemove,rRemove);

        return res;
    }

    private static void backtrack(String s, int start, int lRemove, int rRemove) {
        if(lRemove == 0 && rRemove == 0){

            if(isValid(s)){
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lRemove + rRemove > s.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            String s1 = s.substring(0, i) + s.substring(i + 1);

            if (lRemove > 0 && s.charAt(i) == '(') {
                backtrack(s1, i, lRemove - 1, rRemove);
            }
            // 尝试去掉一个右括号
            if (rRemove > 0 && s.charAt(i) == ')') {
                backtrack(s1, i, lRemove, rRemove - 1);
            }

        }
    }

    private static int[] mustDeleteParenthesesCount(String s){
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                if(left>0){
                    left--;
                }else {
                    right++;
                }
            }
        }

        return new int[]{left,right};
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                count++;
            } else if (curChar == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }

        }
        return count == 0;
    }
}
