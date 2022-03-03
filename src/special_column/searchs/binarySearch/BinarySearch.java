package special_column.searchs.binarySearch;

public class BinarySearch {
    public static int search(int[] arr, int target){
        int l = 0, r = arr.length - 1;

        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] > target){
                r = mid - 1;
            }else if(arr[mid] < target){
                l = mid  + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
