package free.t0314.base36_addition;

/**
 * 原创题
 *
 * 36进制由 0 - 9 ，a - z，共 36 个字符表示。
 * 要求按照加法规则计算出任意两个 36 进制正整数的和，如1b + 2x = 48 （解释：47 + 105 = 152）
 * 要求：不允许使用先将 36 进制数字整体转为 10 进制，相加后再转回为36进制的做法
 *
 * 36进制加法
 */
public class Main {
    public static void main(String[] args) {
        String a = "1b";
        String b = "2x";

        System.out.println(addition(a, b));
    }

    private static String addition(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int m = a.length();
        int n = b.length();

        int idx1 = m - 1, idx2 = n - 1;
        while (idx1 >= 0 || idx2 >= 0){
            int a1 = 0;
            if(idx1 >= 0){
                char acur = a.charAt(idx1);
                a1 = acur > '9' ? acur - 'a' + 10 : acur - '0';
            }

            int b1 = 0;
            if(idx2 >= 0){
                char bcur = b.charAt(idx2);
                b1 = bcur > '9' ? bcur - 'a' + 10 : bcur - '0';
            }

            int sum = a1 + b1 + carry;
            int cur = sum % 36;
            if(cur < 9){
                sb.append(cur);
            }else{
                char re = (char)('a' + cur - 10);
                sb.append(re);
            }

            carry = sum / 36;

            if(idx1 >= 0){
                idx1--;
            }

            if(idx2 >= 0){
                idx2--;
            }
        }

        if(carry > 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
