package sword_to_offer.t0217.zui_xiao_de_kge_shu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * 剑指 Offer 40. 最小的k个数
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,0,2,3,2,1,1,2,0,4};
        int k = 4;

        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[k];
        if(len == 0) return res;

        quickSelect(arr,0,len - 1,k);

        System.arraycopy(arr, 0, res, 0, k);

        return res;
    }

    private static void quickSelect(int[] arr, int l, int r, int k) {
        if(l >= r){
            return;
        }

        int povit = randomPartion(arr,l,r,k);
        if(povit == k){
            return;
        }

        if(povit > k){
            quickSelect(arr,l,povit - 1,k);
        }else {
            quickSelect(arr,povit + 1,r,k);
        }
    }

    private static int randomPartion(int[] arr, int l, int r, int k) {

        int t = (int) (Math.random()*(r - l) + l);

        int temp = arr[l];
        arr[l] = arr[t];
        arr[t] = temp;

        return partion(arr,l,r,k);
    }

    private static int partion(int[] arr, int l, int r, int k) {
        int value = arr[l];

        while (l < r){
            while (l < r && arr[r] > value) r--;
            if(l < r){
                arr[l] = arr[r];
                l++;
            }

            while (l < r && arr[l] < value) l++;
            if(l < r){
                arr[r] = arr[l];
                r--;
            }
        }

        arr[l] = value;

        return l;
    }
}
