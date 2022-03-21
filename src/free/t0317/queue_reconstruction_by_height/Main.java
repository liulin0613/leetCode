package free.t0317.queue_reconstruction_by_height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 *
 * 406. 根据身高重建队列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] people ={
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        int[][] people2 = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};

        System.out.println(Arrays.deepToString(reconstructQueue(people)));
        System.out.println(Arrays.deepToString(reconstructQueue2(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] > o2[0]){
                return 1;
            }else if(o1[0] < o2[0]){
                return -1;
            }else {
                return o1[1] - o2[1];
            }
        });

        System.out.println(Arrays.deepToString(people));

        int[][] res = new int[people.length][];


        for (int[] person : people) {
            int space = 0;
            for (int i = 0; i < res.length; i++) {
                if(res[i] == null || res[i][0] == person[0]){
                    if(space == person[1]){
                        res[i] = person;
                        break;
                    }
                    space++;
                }
            }
        }
        return res;
    }

    public static int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        System.out.println(Arrays.deepToString(people));

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }

        return list.toArray(new int[list.size()][]);
    }
}
