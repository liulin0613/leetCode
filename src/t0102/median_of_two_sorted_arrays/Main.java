package t0102.median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 4. 寻找两个正序数组的中位数
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int len = 1000;
        int[] nums1= new int[len];
        int[] nums2  = new int[len];
        for (int i = 0; i < len; i++) {
            nums1[i]=(int) (Math.random()*1000);
            nums2[i]=(int) (Math.random()*1000);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));

    }

    /**
     * 方法：双指针
     * 每次 while 循环找第 n 小的值
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1=0;
        int p2=0;

        int element_count=nums1.length+nums2.length;
        if(element_count<2){
            return nums1.length>0?nums1[0]:nums2[0];
        }

        int pre=0;
        int p=0;
        while (p1<nums1.length || p2<nums2.length){
            int num;

            if(p1>=nums1.length){
                num=nums2[p2];
                p2++;
            }else if(p2>=nums2.length){
                num=nums1[p1];
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                num=nums2[p2];
                p2++;
            }else {
                num=nums1[p1];
                p1++;
            }

            if(element_count%2!=0 && p==element_count/2){
                return num;
            }

            if(element_count%2==0 && p==element_count/2-1){
                pre=num;
            }

            if(p==element_count/2){
                return (pre+num)/2.;
            }

            p++;

        }

        return 0.;
    }

    /**
     * 方法：复制到大数组，然后排序找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        System.arraycopy(nums1, 0, nums, 0, n1);
        System.arraycopy(nums2, 0, nums, n1, n2);
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 2 == 0) {
            return (nums[(n/2)-1] + nums[n/2])/2.0;
        } else {
            return nums[n/2];
        }
    }
}
