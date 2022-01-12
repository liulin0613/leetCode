package hot_100.t0110.find_the_duplicate_number;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * 287. 寻找重复数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate2(nums));
    }

    /**
     * 使用 HashSet
     * 19 ms 43.71%  50.4 MB 99.26%
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }

        return -1;
    }

    /**
     * 快慢指针
     * i --> nums[i]
     * 等价于 寻找环的入口
     * 4 ms  94.90%  54 MB 70.48%
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 寻找相遇点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        // 寻找入环点
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return  slow;
    }

}
