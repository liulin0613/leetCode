package sword_to_offer.t0302.nge_tou_zi_de_dian_shu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 *
 * 剑指 Offer 60. n个骰子的点数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(Arrays.toString(dicesProbability(n)));
    }

    public static double[] dicesProbability(int n) {
        double[] res = new double[6];
        Arrays.fill(res,1.0/6.);

        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5*i + 1];
            for (int j = 0; j < res.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j+k] += res[j] * 1./6.;
                }
            }

            res = temp;
        }

        return res;
    }
}
