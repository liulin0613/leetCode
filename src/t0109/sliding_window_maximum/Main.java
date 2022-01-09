package t0109.sliding_window_maximum;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 239. 滑动窗口最大值
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * 动态规划，使用优先队列存储最大值
     * 90 ms 7.42%  59.4 MB 5.28%
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] dp = new int[nums.length - k + 1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                ((o1, o2) -> o2[1] - o1[1])
        );

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{i,nums[i]});
        }

        // dp[0] = findMin(nums,0,k);
        dp[0] = queue.peek()[1];

        for (int i = 1; i < dp.length; i++) {
            // 不使用优先队列，使用 findMin
            // dp[i] = nums[i-1] == dp[i-1] ? findMin(nums,i,i+k) : Math.max(dp[i-1],nums[i+k-1]);

            // 使用优先队列
            queue.offer(new int[]{i+k-1,nums[i+k-1]});

            while (queue.peek()[0] < i){
                queue.poll();
            }

            dp[i] = queue.peek()[1];

        }

        return dp;
    }

    private static int findMin(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            max = Math.max(max,nums[i]);
        }

        return max;
    }
}
