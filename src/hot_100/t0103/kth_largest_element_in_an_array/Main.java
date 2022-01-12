package hot_100.t0103.kth_largest_element_in_an_array;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * 215. 数组中的第K个最大元素
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,0};
        int k =1;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,nums.length-k);
        return nums[nums.length-k];
    }

    private static void quickSort(int[] nums, int start, int end,int k) {
        if(start<end){
            int pivot = partition(nums,start,end);
            if(pivot == k) return;
            else if(pivot > k)
                quickSort(nums,0,pivot-1,k);
            else
                quickSort(nums,pivot+1,end,k);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int low = start;
        int high = end;

        int random = (int)(start + Math.random()*(end-start));
        int temp = nums[low];
        nums[low] = nums[random];
        nums[random] = temp;

        int value = nums[low];

        while (low<high){
            while (low<high && nums[high]>value) high--;
            if(low<high){
                nums[low] = nums[high];
                low++;
            }

            while (low<high && nums[low]<value) low++;
            if(low<high){
                nums[high] = nums[low];
                high--;
            }
        }

        nums[low] = value;
        return low;
    }
}
