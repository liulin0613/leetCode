package sword_to_offer.t0302.hua_dong_chuang_kou_de_zui_da_zhi_lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 1;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1,o2) -> o2[1] - o1[1]
        );

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{i,nums[i]});
        }

        res.add(queue.peek()[1]);
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{i,nums[i]});
            while (!queue.isEmpty() && queue.peek()[0] <= i - k){
                queue.poll();
            }

            res.add(queue.peek()[1]);
        }

        int[] re = new int[res.size()];
        int idx = 0;
        for (Integer integer : res) {
            re[idx++] = integer;
        }
        return re;
    }
}
