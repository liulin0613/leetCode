package free.t0307.convert_a_number_to_hexadecimal;

/**
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 *
 * 405. 数字转换为十六进制数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int num = -1;

        System.out.println(toHex(num));
    }

    public static String toHex(int num) {
        if(num == 0){
            return String.valueOf(0);
        }

        String lib = "0123456789abcdef";

        long temp = num;
        if (num < 0){
            temp = (long) (Math.pow(2,32) + num);
        }

        StringBuilder sb = new StringBuilder();
        while (temp > 0){
            sb.append(lib.charAt((int) (temp % 16)));
            temp /= 16;
        }

        return sb.reverse().toString();
    }
}
