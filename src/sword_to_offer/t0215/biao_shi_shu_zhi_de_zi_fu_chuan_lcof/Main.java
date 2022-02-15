package sword_to_offer.t0215.biao_shi_shu_zhi_de_zi_fu_chuan_lcof;

/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 *
 * 剑指 Offer 20. 表示数值的字符串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "9";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        s= s.trim();
        try {
            Double.parseDouble(s);
            return (s.charAt(s.length()-1) >= '0' && s.charAt(s.length()-1) <= '9') || s.charAt(s.length()-1) == '.';
        }catch (NumberFormatException e){
            return false;
        }
    }
}
