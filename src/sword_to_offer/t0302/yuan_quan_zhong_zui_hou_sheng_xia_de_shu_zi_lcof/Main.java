package sword_to_offer.t0302.yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 *
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 5 , m = 3;

        System.out.println(lastRemaining(n, m));
        System.out.println(lastRemaining2(n, m));
    }

    public static int lastRemaining(int n, int m) {
        int f = 0;

        for (int i = 2; i <= n; ++i) {
            f = (f + m) % i;
        }

        return f;
    }

    public static int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

}
