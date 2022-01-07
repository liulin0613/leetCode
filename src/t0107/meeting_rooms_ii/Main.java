package t0107.meeting_rooms_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 *
 * 253. 会议室 II
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] intervals = {
                {5,8},{6,8}
        };

        System.out.println(minMeetingRooms(intervals));
    }

    /**
     * 优先队列 + 排序
     * @param intervals
     * @return
     */
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length<2){
            return intervals.length;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (queue.size() != 0) {
                int end = queue.peek();
                if (end <= interval[0]) {
                    queue.poll();
                }

            }

            queue.offer(interval[1]);
        }

        return queue.size();
    }
}
