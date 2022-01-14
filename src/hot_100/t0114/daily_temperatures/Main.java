package hot_100.t0114.daily_temperatures;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * 739. 每日温度
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] temperatures = new int[]{30,60,90};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }

    /**
     * 暴力解法
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                count++;
                if(temperatures[j] > temperatures[i]){
                    res[i] = count;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 从最后一天推到第一天
     * 最后一天显然不会再有升高的可能，结果直接为 0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为 1
     * 如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若 T[i] < T[i+1]，那么 res[i]=1；
     * - 若 T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较 T[i]和 T[i+1+res[i+1]]
     *   （即将第i天的温度与比第i+1天大的那天的温度进行比较）
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += res[j]) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
