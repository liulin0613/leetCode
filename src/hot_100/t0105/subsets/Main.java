package hot_100.t0105.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * 78. 子集
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(subsets(nums));
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;
    }

    private static void backtrack(int start, int[] nums,List<Integer> path, List<List<Integer>> result) {
        if(!result.contains(path)){
            result.add(new ArrayList<>(path));
        }

        if(path.size() == nums.length){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i+1,nums,path,result);
            path.remove(path.size() - 1);
        }
    }
}
