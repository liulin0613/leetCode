package t0104.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * 46. 全排列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }

        // 不能重复使用的数据可以用一个 used 数组
        // 可以重复使用的数据可以用 start 标志
        boolean[] used = new boolean[nums.length];
        backtrack(0,nums,used,new ArrayList<>(),res);

        return res;
    }

    private static void backtrack(int cur, int[] nums, boolean[] used,ArrayList<Integer> path, List<List<Integer>> res) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtrack(cur+1,nums,used,path,res);
                used[i] = false;
                path.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}
