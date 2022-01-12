package hot_100.t0106.largest_rectangle_in_histogram;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * 84. 柱状图中最大的矩形
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * 在一维数组中找第一个满足某种条件的数  --> 单调栈
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i=heights.length-1; i>=0;i--){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            right[i]=stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }

        int max=0;
        for (int i = 0; i < heights.length; i++) {
            max =Math.max(max,heights[i]*(right[i]-left[i]-1));
        }

        return max;
    }

    /**
     * 以一根柱子为轴，向两侧扩散
     * 超时 --> 如果全部相等，退化到 o(n^2)
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int max=0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && heights[left] >= heights[i]) left--;
            while (right < heights.length && heights[right] >= heights[i]) right++;

            max = Math.max(max,heights[i]*(right-left-1));
        }
        return max;
    }
}
