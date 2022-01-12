package hot_100.t0107.word_break;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 *
 * 139. 单词拆分
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcdde";
        List<String> wordDic = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDic));
    }

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {

                dp[i] = dp[j] && wordDict.contains(s.substring(j,i));

                if(dp[i]){
                    break;
                }
            }
        }

        return dp[len];
    }
}
