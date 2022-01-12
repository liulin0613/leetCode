package hot_100.t0112.target_sum;

/**
 * https://leetcode-cn.com/problems/target-sum/
 *
 * 494. 目标和
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }

    static int count = 0;

    /**
     * 回溯
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,0,target);
        return count;
    }

    private static void backtrack(int[] nums, int index, int cur, int target) {
        if(index == nums.length ){
            if(cur == target){
                count++;
            }

        }else {
            backtrack(nums,index+1,cur + nums[index],target);
            backtrack(nums,index+1,cur - nums[index],target);
        }
    }
}
