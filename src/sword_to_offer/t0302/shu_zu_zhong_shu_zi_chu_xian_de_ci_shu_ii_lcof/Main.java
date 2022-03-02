package sword_to_offer.t0302.shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {9,1,7,9,1,1,1,7,7,9,7,9,8};

        System.out.println(singleNumber(nums));
    }

    /**
     * 统计每一位上 1 的个数，再对 m 取余
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < count.length; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0, m = 4;
        for (int i = 0; i < count.length; i++) {
            res <<= 1;
            res |= count[count.length - i - 1] % m;
        }

        return res;
    }
}
