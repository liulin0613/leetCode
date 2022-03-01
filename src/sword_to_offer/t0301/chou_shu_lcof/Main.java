package sword_to_offer.t0301.chou_shu_lcof;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * 剑指 Offer 49. 丑数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;

        System.out.println(nthUglyNumber2(n));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    private static int nthUglyNumber2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a]*2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2,n3),n5);

            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }

        return dp[n-1];
    }

    /**
     * 优先队列
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] num = {2,3,5};
        HashSet<Long> longs = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();

        long root = 1L;
        longs.add(root);
        queue.offer(root);

        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur = queue.poll();
            for (int i1 : num) {
                if(longs.add(cur * i1)){
                    queue.offer(cur * i1);
                }
            }
        }

        return (int) cur;
    }


}
