package sword_to_offer.t0216.shu_zhi_de_zheng_shu_ci_fang_lcof;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * 剑指 Offer 16. 数值的整数次方
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2147483647;

        System.out.println(myPow(x, n));
        System.out.println(myPow2(x, n));
    }

    /**
     * 暴力解法，超时
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        double res = 1.;

        if(n > 0){
            for(int i = 0; i < n; i++){
                res *= x;
            }
        }else {
            double y = 1. / x;
            for(int i = 0; i < -1*n; i++){
                res *= y;
            }
        }

        return res;
    }

    /**
     * 快速幂
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;

        if(b < 0) {
            x = 1 / x;
            b = -b;
        }

        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }

        return res;
    }

}
