package t0105.minimum_window_substring;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * 76. 最小覆盖子串
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcvascsasacvsvascascvgrhyjoplikneqerwetuyomfvdv";
        String t = "cascgracasc";

        System.out.println(minWindow(s, t));
    }

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        // s 长度小，直接返回
        if(s.length() < t.length()){
            return "";
        }

        // s 长度大
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else {
                map.put(t.charAt(i),1);
            }
        }

        // s 字符串预处理
        int left = 0;
        int right = s.length() -1;
        while (left < right && !map.containsKey(s.charAt(left))) left++;
        while (left < right && !map.containsKey(s.charAt(right))) right--;

        s = s.substring(left,right+1);

        // 长度相等，比较是否是异位同构字符串
        if(s.length() == t.length()){
            char[] ch1 = s.toCharArray();
            char[] ch2 = t.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String nch1 = String.valueOf(ch1);
            String nch2 = String.valueOf(ch2);

            return nch1.equals(nch2)?s:"";
        }

        // 长度不等，使用 滑动窗口
        Map<Character,Integer> cur = new HashMap<>();

        left = 0;
        right = -1;
        int len = s.length()+1, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (right < sLen){
            right++;

            if(right < sLen && map.containsKey(s.charAt(right))){
                cur.put(s.charAt(right),cur.getOrDefault(s.charAt(right),0)+1);
            }

            while (check(map,cur) && left <= right){
                if(right - left + 1 <len){
                    len = right - left +1;
                    ansL = left;
                    ansR = right;
                }

                if(map.containsKey(s.charAt(left))){
                    cur.put(s.charAt(left),cur.getOrDefault(s.charAt(left),0)-1);
                }

                left++;
            }
        }

        return  ansL == -1 ? "" : s.substring(ansL,ansR+1);
    }

    private static boolean check(Map<Character, Integer> map, Map<Character, Integer> cur) {
        for (Character character : map.keySet()) {
            if(!cur.containsKey(character)){
                return false;
            }else {
                if(cur.get(character) < map.get(character)){
                    return false;
                }
            }
        }
        return true;
    }
}
