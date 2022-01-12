package hot_100.t0103.container_with_most_water;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 11. 盛最多水的容器
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int max=0;

        while (left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            max = Math.max(area,max);

            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }

        return max;
    }

}
