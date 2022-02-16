package sword_to_offer.t0216.da_yin_cong_1dao_zui_da_de_nwei_shu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(Arrays.toString(printNumbers(n)));
    }

    public static int[] printNumbers(int n) {
        int max = (int) Math.pow(10,n)  - 1;
        int[] res = new int[max];

        for(int i = 0; i < max; i++){
            res[i] = i + 1;
        }

        return res;
    }
}
