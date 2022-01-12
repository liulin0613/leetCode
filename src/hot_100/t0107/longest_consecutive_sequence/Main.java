package hot_100.t0107.longest_consecutive_sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * 128. 最长连续序列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));
    }


    /**
     * 使用 set 去重 + 判断 时间复杂度 o(n)
     * 14 ms 58.18%  54.6 MB  5.44%
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (Integer integer : set) {
            if(!set.contains(integer-1)){
                int len = 1;

                // 内层 while 循环，每个数只进一次
                while (set.contains(integer+1)){
                    len++;
                    integer++;
                }

                maxLen = Math.max(maxLen,len);
            }
        }

        return maxLen;
    }


    /**
     * 排序去重，时间复杂度 o(nlogn)
     *  10 ms 99.86%  44.3 MB 96.68%
     * @param nums
     * @return
     */
    public static int longestConsecutive2(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        Arrays.sort(nums);

        int maxLen = 0;

        int len = 1;
        int current = nums[0];
        for (int num : nums) {
            if(num == current) continue;

            if(num - current == 1) {
                len++;
            }else {
                maxLen = Math.max(maxLen,len);
                len = 1;
            }

            current = num;
        }

        return Math.max(maxLen,len);
    }
}
