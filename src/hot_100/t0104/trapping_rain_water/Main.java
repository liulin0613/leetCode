package hot_100.t0104.trapping_rain_water;


/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 42. 接雨水
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] height = new int[]{1,2,0,2};

        System.out.println(trap2(height));
    }

    /**
     * 方法一：动态规划  1ms 38.1M
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height.length<1) return 0;

        int max = 0;
        // 正向遍历得到 leftMax
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        max = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = max;
            max = Math.max(height[i],max);
        }

        // 反向遍历得到 rightMax
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = 0;
        max = height[height.length-1];
        for (int length = height.length-2; length >= 0; length--) {
            rightMax[length] = max;
            max=Math.max(max,height[length]);
        }

        int[] dp = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            dp[i] = Math.min(leftMax[i],rightMax[i]) - height[i];
            dp[i] = Math.max(dp[i], 0);
        }

        int sum=0;
        for (int i : dp) {
            sum += i;
        }

        return sum;
    }

    /**
     * 双指针 1ms 38.2M
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            // 左边的挡板小，leftMax 可以确定
            if(height[left] < height[right]){
                ans += Math.max(leftMax - height[left],0);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }else {
                ans += Math.max(rightMax - height[right],0);
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        }

        return ans;
    }
}
