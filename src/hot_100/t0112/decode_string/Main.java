package hot_100.t0112.decode_string;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/
 *
 * 394. 字符串解码
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "2[abc]";

        System.out.println(decodeString(s));
    }

    /**
     * 通过两个栈 numStack and CharStack
     * 5 ms  10.61%  38.7 MB  5.04%
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if(ch >= '1' && ch <= '9'){
                int num = Integer.parseInt(ch+"");
                while (s.charAt(++i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + Integer.parseInt(s.charAt(i)+"");
                }
                numStack.push(num);
            }else{
                if(ch == ']'){
                    StringBuilder sb = new StringBuilder();
                    char pop = charStack.pop();
                    while (pop != '['){
                        sb.append(pop);
                        pop = charStack.pop();
                    }

                    sb.reverse();

                    int time = numStack.pop();
                    String dummy = sb.toString();

                    for (int j = 0; j < time-1; j++) {
                        sb.append(dummy);
                    }

                    dummy = sb.toString();
                    for (int j = 0; j < dummy.length(); j++) {
                        charStack.push(dummy.charAt(j));
                    }
                }else {
                    charStack.push(ch);
                }

                i++;
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()){
            sb.append(charStack.pop());
        }

        return sb.reverse().toString();
    }
}
