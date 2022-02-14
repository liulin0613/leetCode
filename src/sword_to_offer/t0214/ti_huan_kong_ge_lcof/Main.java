package sword_to_offer.t0214.ti_huan_kong_ge_lcof;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * 剑指 Offer 05. 替换空格
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
