package free.t0314.distinct_subsequences;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 *
 * 115. 不同的子序列
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));
    }

    private static int count = 0;

    public static int numDistinct(String s, String t) {
        dfs(s,t,new StringBuilder(),0,0);

        return count;
    }

    private static void dfs(String s, String t, StringBuilder sb, int cur,int len) {
        if(sb.toString().equals(t)){
            count++;
            return;
        }else if(sb.length() == t.length()){
            return;
        }

        for (int i = cur; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(len)){
                sb.append(s.charAt(i));
                dfs(s,t,sb,i + 1,len + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
