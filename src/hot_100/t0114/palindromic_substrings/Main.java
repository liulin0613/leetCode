package hot_100.t0114.palindromic_substrings;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 647. 回文子串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "abc";

        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings2(s));
    }

    /**
     * 暴力穷举
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int len = s.length();
        if(len == 1){
            return 1;
        }

        int count = 1;

        for (int i = 1; i < len; i++) {
            count++;
            for (int j = i-1; j >= 0; j--) {
                if(isPalindromic(s,j,i)){
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isPalindromic(String s, int start, int end) {
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    static int num = 0;

    /**
     * 枚举回文中心
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        for (int i=0; i < s.length(); i++){
            //回文串长度为奇数
            count(s, i, i);
            //回文串长度为偶数
            count(s, i, i+1);
        }
        return num;
    }

    public static void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }
}
