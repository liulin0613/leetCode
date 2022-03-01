package sword_to_offer.t0301.zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan_lcof;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int rk = -1;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(i > 0){
                set.remove(s.charAt(i-1));
            }

            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))){
                set.add(s.charAt(rk + 1));
                rk++;
            }

            max = Math.max(max,rk - i + 1);
        }

        return max;
    }
}
