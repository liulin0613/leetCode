package sword_to_offer.t0302.bu_ke_pai_zhong_de_shun_zi_lcof;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,3,4,5};

        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxNum = -1;
        int minNum = 14;

        for (int num : nums) {
            if(num == 0) continue;
            if(set.contains(num)) return false;
            set.add(num);

            maxNum = Math.max(maxNum,num);
            minNum = Math.min(minNum,num);
        }


        return maxNum - minNum < 5;
    }
}
