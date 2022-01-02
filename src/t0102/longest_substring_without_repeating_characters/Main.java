package t0102.longest_substring_without_repeating_characters;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 3. 无重复字符的最长子串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcabcdabc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }

        int maxLen=0;
        int index = -1;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(i>0){
                set.remove(s.charAt(i-1));
            }

            while ((index+1)<s.length() && !set.contains((s.charAt(index+1)))){
                set.add(s.charAt(index+1));
                index++;
            }

            maxLen=Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
