package sword_to_offer.t0216.zheng_ze_biao_da_shi_pi_pei_lcof;

/**
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 *
 * 面试题19. 正则表达式匹配
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean[][] dp =new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1)=='*'){
                    if(matches(s,p,i,j-1)){
                        dp[i][j]= dp[i-1][j] || dp[i][j-2];
                    }else {
                        dp[i][j]=dp[i][j-2];
                    }
                }else {
                    if(matches(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private static   boolean matches(String s,String p,int m,int n){
        if(m==0){
            return false;
        }

        if(p.charAt(n-1)=='.'){
            return true;
        }

        return s.charAt(m-1) == p.charAt(n-1);
    }
}
