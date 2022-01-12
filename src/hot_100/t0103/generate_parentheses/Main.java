package hot_100.t0103.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 22. 括号生成
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<1){
            return result;
        }

        generate("",result,n,n);

        return result;
    }

    private static void generate(String s, List<String> result, int left, int right) {
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
        if(left == right){
            generate(s+"(",result,left-1,right);
        }else if(left < right){
            if(left > 0){
                generate(s+"(",result,left-1,right);
            }

            generate(s+")",result,left,right-1);
        }
    }
}
