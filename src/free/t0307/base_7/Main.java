package free.t0307.base_7;

/**
 * https://leetcode-cn.com/problems/base-7/
 *
 * 504. 七进制数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int num = -1;

        System.out.println(convertToBase7(num));
    }

    public static String convertToBase7(int num) {
        if(num == 0){
            return String.valueOf(0);
        }
        StringBuilder sb = new StringBuilder();
        boolean fs = num < 0;
        num = num > 0 ? num : -num;
        while (num > 0){
            sb.append(num % 7);
            num /= 7;
        }

        if(fs) sb.append("-");
        return sb.reverse().toString();
    }
}
