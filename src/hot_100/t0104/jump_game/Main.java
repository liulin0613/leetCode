package hot_100.t0104.jump_game;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 55. 跳跃游戏
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }

    /**
     * 贪心算法 2ms 39.8M
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }

        int maxLen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i <= maxLen){
                maxLen = Math.max(maxLen,i + nums[i]);
                if(maxLen >= nums.length -1){
                    return true;
                }
            }else {
                return false;
            }
        }

        return false;
    }


    /**
     * 动态规划 926ms 39.6M
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        if(nums.length <= 1){
            return true;
        }

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0]=true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && i-j<=nums[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
