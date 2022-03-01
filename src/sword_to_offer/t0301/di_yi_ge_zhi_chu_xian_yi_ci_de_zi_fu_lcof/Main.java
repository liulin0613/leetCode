package sword_to_offer.t0301.di_yi_ge_zhi_chu_xian_yi_ci_de_zi_fu_lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "deeacofe";

        System.out.println(firstUniqChar2(s));
    }

    public static char firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) count[c - 'a']++;
        System.out.println(Arrays.toString(count));
        for (char c : chars) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }

    public static char firstUniqChar(String s) {
        if(s.length() == 0){
            return ' ';
        }

        List<Character> list = new ArrayList<>();
        List<Character> copy = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
                copy.add(s.charAt(i));
            }else {
                if(copy.contains(s.charAt(i))){
                    copy.remove(Character.valueOf(s.charAt(i)));
                }
            }
        }

        return copy.size() == 0 ? ' ' : copy.get(0);
    }
}
