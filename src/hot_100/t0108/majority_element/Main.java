package hot_100.t0108.majority_element;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * 169. 多数元素
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,1,1,1,1,1};
        System.out.println(majorityElement(nums));
    }

    /**
     * 投票选举法
     * 1 ms 99.92%  44.3 MB 46.78%
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if(num == candidate){
                count++;
            }else {
                count--;
                if (count == 0){
                    candidate = num;
                    count = 1;
                }
            }
        }

        return candidate;
    }
}
