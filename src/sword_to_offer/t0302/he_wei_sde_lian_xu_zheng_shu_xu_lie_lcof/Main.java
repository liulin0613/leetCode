package sword_to_offer.t0302.he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int target = 15;

        System.out.println(Arrays.deepToString(findContinuousSequence(target)));
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        int curNum = 0;
        for (int i = 1; i <= (target + 1) / 2; i++) {
            curNum += i;
            cur.add(i);

            while (curNum > target){
                curNum -= cur.remove(0);
            }

            if(curNum == target){
                int[] r = new int[cur.size()];
                int idx = 0;
                for (Integer integer : cur) {
                    r[idx++] = integer;
                }
                lists.add(r);
            }
        }


        return lists.toArray(new int[lists.size()][]);
    }
}
