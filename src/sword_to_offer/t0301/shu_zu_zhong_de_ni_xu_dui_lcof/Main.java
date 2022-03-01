package sword_to_offer.t0301.shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * 剑指 Offer 51. 数组中的逆序对
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};

        System.out.println(reversePairs(nums));
    }

    static int count = 0;
    public static int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length - 1,new int[nums.length]);
        return count;
    }

    private static void mergeSort(int[] nums, int start, int end,int[] temp) {
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(nums,start,mid,temp);
            mergeSort(nums,mid + 1,end,temp);

            merge(nums,start,mid,end,temp);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end,int[] temp) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end){
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else {
                count += (mid - i + 1);
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid){
            temp[t++] = nums[i++];
        }

        while (j <= end){
            temp[t++] = nums[j++];
        }

        t = 0;
        while (start <= end){
            nums[start++] = temp[t++];
        }
    }
}
