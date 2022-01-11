package t0111.top_k_frequent_elements;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 347. 前 K 个高频元素
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,3,4,4,4,4};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }

    /**
     * 使用容器 map 排序
     * 15 ms 25.16%  41.1 MB 42.40%
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }

    /**
     * 使用 堆排序
     * 14 ms  40.55%  40.8 MB  82.96%
     * @param nums
     * @param k
     * @return
     */
    private static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            if(queue.size() < k){
                queue.offer(key);
            }else {
                if(queue.peek().getValue() < key.getValue()){
                    queue.poll();
                    queue.offer(key);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }
}
