package hot_100.t0112.queue_reconstruction_by_height;

import java.util.*;

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
        int[][] people = {
                {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };

        System.out.println(Arrays.deepToString(reconstructQueue2(people)));
    }

    /**
     * 按照升高升序
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        // 按照 person[0] 升序，person[0] 相同，按照 person[1] 降序
        Arrays.sort(people, (o1,o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

        int n = people.length;
        int[][] ans = new int[n][];

        // person[0] 前面留 person[1] 个空位
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for(int i = 0; i < n ; i++){
                if(ans[i] == null){
                    --spaces;
                    if(spaces == 0){
                        ans[i] = person;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 按照升高降序
     * @param people
     * @return
     */
    public static int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }

        return list.toArray(new int[list.size()][]);
    }

}
