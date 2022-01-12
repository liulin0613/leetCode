package hot_100.t0112.hamming_distance;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * 461. 汉明距离
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int x = 1, y = 3;

        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        // 相同为 0 不同为 1
        int z = x ^ y;

        // 统计有多少个 1
        int count = 0;
        while (z != 0){
            z &= (z-1);
            count++;
        }

        return count;
    }
}
