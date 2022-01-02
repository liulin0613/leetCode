package t0102.longest_palindromic_substring;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 5. 最长回文子串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 动态规划算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 初始化数组，对角线赋值为 true
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        char[] charArray=s.toCharArray();

        for(int L=2;L<=len;L++){
            for(int i=0;i<len;i++){
                int j=L+i-1;
                if(j>=len){
                    break;
                }

                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
