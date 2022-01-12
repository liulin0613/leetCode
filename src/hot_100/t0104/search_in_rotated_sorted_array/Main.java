package hot_100.t0104.search_in_rotated_sorted_array;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * 33. 搜索旋转排序数组
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){

            int mid = left + ((right-left) >> 1);

            if(nums[mid] < nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        if(target>nums[nums.length-1]){
            return searchFor(nums,0,left-1,target);
        }else {
            return searchFor(nums,left,nums.length-1,target);
        }
    }

    private static int searchFor(int[] nums, int left, int right,int target) {
        while (left < right){
            int mid = left + ((right-left) >> 1);

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
