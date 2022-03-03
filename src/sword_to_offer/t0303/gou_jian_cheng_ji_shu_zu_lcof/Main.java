package sword_to_offer.t0303.gou_jian_cheng_ji_shu_zu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 *
 * 剑指 Offer 66. 构建乘积数组
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        System.out.println(Arrays.toString(constructArr(a)));
    }

    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] leftMax = new int[len];
        if(len == 0 ) return leftMax;

        leftMax[0] = 1;
        for (int i = 0; i < len-1; i++) {
            leftMax[i+1] = a[i] * leftMax[i];
        }

        int[] res = new int[len];

        int rightMax = 1;
        for (int i = len-1; i >= 0; i--) {
            res[i] = leftMax[i] * rightMax;
            rightMax *= a[i];
        }

        return res;
    }
}
