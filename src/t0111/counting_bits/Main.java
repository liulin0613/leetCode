package t0111.counting_bits;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * 338. 比特位计数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(Arrays.toString(countBits(n)));
    }

    /**
     * 每一个数字 计算 1 的数量
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }

        return res;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] res = new int[n+1];
        int highBit = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }

        return res;
    }

    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            // x = x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
