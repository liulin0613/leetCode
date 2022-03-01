package sword_to_offer.t0301.shu_zi_xu_lie_zhong_mou_yi_wei_de_shu_zi_lcof;

/**
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 *
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 1024;

        System.out.println(findNthDigit(n));
    }

    /**
     * 1. 确定所求数位的所在数字的位数
     *      digit   start   end     count
     *      1       1       9       9
     *      2       10      99      90 * 2
     *      ...
     *                              digit * start * 9
     *
     * 2. 确定所求数位所在的数字
     *      start + (n - 1) / digit
     *
     * 3. 确定所求数位在 num 的哪一数位
     *      (n - 1) % digit
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit; // 2.

        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
