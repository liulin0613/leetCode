package sword_to_offer.t0214.fei_bo_na_qi_shu_lie_lcof;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * 剑指 Offer 10- I. 斐波那契数列
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int n0 = 0, n1 = 1,temp;

        if(n == 0) return n0;
        if(n == 1) return n1;

        for (int i = 2; i <= n; i++) {
            temp = n1;
            n1 = (n0 + n1) % 1000000007;
            n0 = temp;
        }

        return n1;
    }
}
