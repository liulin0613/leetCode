package t0109.course_schedule;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * 207. 课程表
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {
                {0,1},
                {2,0},
                {1,2}
        };

        System.out.println(canFinish(numCourses, prerequisites));
    }

    /**
     * Spring 循环依赖检测
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> maps = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if(!maps.containsKey(prerequisite[0])){
                HashSet<Integer> set = new HashSet<>();
                set.add(prerequisite[1]);
                maps.put(prerequisite[0],set);
            }else {
                HashSet<Integer> set = maps.get(prerequisite[0]);
                set.add(prerequisite[1]);
            }
        }

        for (Integer key : maps.keySet()) {
            boolean res = doCreate(key,maps,state);
            if(!res){
                return false;
            }
        }


        return true;
    }

    private static boolean doCreate(Integer key, HashMap<Integer, HashSet<Integer>> maps,int[] state) {
        if(state[key] == 2){
            System.out.println("use created " + key);
            return true;
        }

        if(state[key] == 1){
            System.out.println( key + " is creating，i can't solve ");
            return false;
        }

        if(!maps.containsKey(key)){
            state[key] = 2;
            System.out.println("creating " + key + "..");
            System.out.println("created " + key);
            return true;
        }

        state[key] = 1;
        System.out.println("creating " + key + "..");

        Set<Integer> set = maps.get(key);
        for (Integer prerequisite : set) {
            boolean res =doCreate(prerequisite,maps,state);
            if(!res){
                return false;
            }
        }

        state[key] = 2;
        System.out.println("created " + key);
        return true;
    }
}
