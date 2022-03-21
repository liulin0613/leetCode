package free.t0307.string_to_integer_atoi;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * 8. 字符串转换整数 (atoi)
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "-20000000000000000000";

        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        s = s.trim();
        int start = -1;
        int end = -1;
        boolean neg = false;
        for(int i = 0; i < s.length(); i++){
            if(i == 0 && s.charAt(i) == '+'){
                continue;
            }else if(i == 0 && s.charAt(i) == '-'){
                neg = true;
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                if(start == -1){
                    start = i;
                }
                end = i;
            }else {
                if(start == -1){
                    return 0;
                }else {
                    break;
                }
            }
        }

        if(start == -1){
            return 0;
        }

        try {
            int res = Integer.parseInt(s.substring(start,end+1));
            return neg ? -res : res;
        }catch (Exception e){
            if(neg){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
