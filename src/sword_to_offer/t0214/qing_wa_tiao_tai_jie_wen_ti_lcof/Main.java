package sword_to_offer.t0214.qing_wa_tiao_tai_jie_wen_ti_lcof;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(numWays(n));
    }

    public static int numWays(int n) {
        int n0 = 1, n1 = 1 , r;
        for (int i = 2; i <= n; i++) {
            r = n1;
            n1 = (n0 + n1) % 1000000007;
            n0 = r;
        }

        return n1;
    }
}
