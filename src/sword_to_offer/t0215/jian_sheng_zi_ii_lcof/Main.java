package sword_to_offer.t0215.jian_sheng_zi_ii_lcof;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 *
 * 剑指 Offer 14- II. 剪绳子 II
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n= 1000;
        System.out.println(cuttingRope(n));
    }

    public static int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;

        long res = 1L;
        while (n > 4){
            res = res * 3 % 1000000007;
            n -= 3;
        }

        return (int)(res * n % 1000000007);
    }
}
