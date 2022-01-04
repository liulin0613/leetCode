package t0104.combination_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 39. 组合总和
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length<1){
            return result;
        }

        int len = candidates.length;
        getPath(0,len,target,candidates,new ArrayList<>(),result);

        return result;
    }

    private static void getPath(int begin, int len, int target,int[] candidates, ArrayList<Integer> path, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        for (int i = begin; i < len; i++) {
            path.add(candidates[i]);
            getPath(i,len,target-candidates[i],candidates,path,result);
            path.remove(Integer.valueOf(candidates[i]));
        }

//        for (int candidate : candidates) {
//            path.add(candidate);
//            getPath(0,len,target-candidate,candidates,path,result);
//            path.remove(Integer.valueOf(candidate));
//        }
    }
}
