package free.t0317.partition_equal_subset_sum;

public class Main {
    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};

        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        return dfs(nums,0,sum,0);
    }

    private static boolean dfs(int[] nums,int idx,int sum,int cur){
        if(cur > sum / 2){
            return false;
        }

        if(cur == sum / 2){
            return true;
        }

        for(int i = idx; i < nums.length; ++i){
            boolean res = dfs(nums,i + 1, sum, cur + nums[i]);
            if(res){
                return true;
            }
        }

        return false;
    }
}
