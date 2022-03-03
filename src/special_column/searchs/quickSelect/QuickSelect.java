package special_column.searchs.quickSelect;

/**
 * Top K 问题  ==> 在未排序的数组中找到第 k 大的元素
 * 快速选择算法
 *
 * @author liulin
 */
public class QuickSelect {
    public static int select(int[] arr, int target){
        target = arr.length - target;
        int left = 0, right = arr.length - 1;

        while (true){
            int position = partion(arr,left,right);
            if(position < target){
                left = position + 1;
            }else if(position > target){
                right = position - 1;
            }else {
                return arr[position];
            }
        }
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = left;
        int value = arr[pivot];

        while (left < right){
            while (left < right && arr[right] > value) right--;
            if(left < right){
                arr[left] = arr[right];
                left++;
            }

            while (left < right && arr[left] <= value) left++;
            if(left < right){
                arr[right] = arr[left];
                right--;
            }
        }

        arr[left] = value;

        return left;
    }
}
