package hot_100.t0114.task_scheduler;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/task-scheduler/
 *
 * 621. 任务调度器
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        // n = 0 , 顺序执行即可
        if(n == 0){
            return tasks.length;
        }

        int[] count = new int[26];

        //统计词频
        for (char task : tasks) {
            count[task - 'A'] ++;
        }

        //词频排序，升序排序，count[25]是频率最高的
        Arrays.sort(count);

        int maxCount = 0;

        //统计有多少个频率最高的字母
        for (int i = 25; i >= 0; i--) {
            if(count[i] != count[25]){
                break;
            }
            maxCount++;
        }

        // 公式算出的值可能会比数组的长度小，取两者中最大的那个
        // Axx Axx A
        //  Bxx Bxx B
        // count[25] = 3 , 最多少任务出现三次
        // maxCount = 2 , 有两个最多次数的任务
        return Math.max((count[25] - 1) * (n + 1) + maxCount , tasks.length);
    }
}
