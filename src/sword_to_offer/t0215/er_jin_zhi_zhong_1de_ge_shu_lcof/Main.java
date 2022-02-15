package sword_to_offer.t0215.er_jin_zhi_zhong_1de_ge_shu_lcof;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * 剑指 Offer 15. 二进制中1的个数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 1294967293;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n &=(n -1);
            count++;
        }

        return count;
    }
}
