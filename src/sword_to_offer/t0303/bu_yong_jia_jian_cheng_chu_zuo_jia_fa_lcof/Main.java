package sword_to_offer.t0303.bu_yong_jia_jian_cheng_chu_zuo_jia_fa_lcof;

/**
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 *
 * 剑指 Offer 65. 不用加减乘除做加法
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int a = -1, b = 7;

        System.out.println(add(a, b));
    }

    public static int add(int a, int b) {
        while (b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }

        return a;
    }
}
