package t0107.single_number;

import java.util.HashSet;
/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * 136. 只出现一次的数字
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{4,1,2,4,2};
        System.out.println(singleNumber2(num));
    }

    /**
     * 方法一：使用集合（set、map等）存储元素
     * 时间复杂度 O(n),空间复杂度 O(n)
     * 10 ms 16.35%  38.9 MB 10.68%
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }

        for (Integer integer : set) {
            return integer;
        }

        return -1;
    }

    /**
     * 方法二：使用位运算
     * 时间复杂度 O(n),空间复杂度 O(1)
     * 1 ms 100.00%   38.7 MB 21.27%
     * @param nums
     * @return
     */
    private static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
