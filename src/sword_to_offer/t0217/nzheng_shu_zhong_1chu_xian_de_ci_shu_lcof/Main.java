package sword_to_offer.t0217.nzheng_shu_zhong_1chu_xian_de_ci_shu_lcof;

/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 *
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(countDigitOne(n));
    }


    public static int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
