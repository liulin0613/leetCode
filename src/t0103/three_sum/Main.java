package t0103.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * 15. 三数之和
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                break;
            }

            while (i>0 && i<nums.length && nums[i]==nums[i-1]){
                i++;
            }

            int left = i+1;
            int right = nums.length-1;

            while (left<right){

                if(nums[left]+nums[right]+nums[i]==0){

                    List<Integer> list = Arrays.asList(nums[i],nums[left],nums[right]);
                    result.add(list);

                    while (left<right && nums[left+1] == nums[left]) left++;
                    while (left<right && nums[right-1] == nums[right]) right--;

                    left++;
                    right--;
                }else if(nums[left]+nums[right]+nums[i]>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
