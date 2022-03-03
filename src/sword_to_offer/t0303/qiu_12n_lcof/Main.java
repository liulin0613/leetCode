package sword_to_offer.t0303.qiu_12n_lcof;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * 剑指 Offer 64. 求1+2+…+n
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 9;

        System.out.println(sumNums(n));
    }

    public static int sumNums(int n) {
        boolean flag = n>0 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
