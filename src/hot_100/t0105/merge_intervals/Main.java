package hot_100.t0105.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 56. 合并区间
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3}};

        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge2(intervals)));
    }

    /**
     * 排序 + 遍历合并
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if(intervals.length<2){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int min = intervals[0][0];
        int max = intervals[0][1];

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > max) {
                lists.add(Arrays.asList(min, max));
                min = intervals[i][0];
            }

            max = Math.max(max,intervals[i][1]);
        }

        lists.add(Arrays.asList(min, max));

        int[][] result = new int[lists.size()][2];
        int idx = 0;
        for (List<Integer> list : lists) {
            result[idx][0] = list.get(0);
            result[idx++][1] = list.get(1);
        }

        return result;
    }

    /**
     * 改进存储方式
     * @param intervals
     * @return
     */
    public static int[][] merge2(int[][] intervals) {
        if(intervals.length<2){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int min = intervals[0][0];
        int max = intervals[0][1];

        List<int[]> lists = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > max) {
                lists.add(new int[]{min,max});
                min = intervals[i][0];
            }

            max = Math.max(max,intervals[i][1]);
        }

        lists.add(new int[]{min,max});

        return lists.toArray(new int[lists.size()][]);
    }
}


