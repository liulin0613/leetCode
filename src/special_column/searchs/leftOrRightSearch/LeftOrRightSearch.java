package special_column.searchs.leftOrRightSearch;

public class LeftOrRightSearch {
    public static int findLeft(int[] arr, int target){
        int l = 0, r = arr.length - 1;

        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int findRight(int[] arr, int target){
        int l = 0, r = arr.length - 1;

        while (l <= r){
            int mid = l + ((r - l) >> 1);
            if(arr[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return r;
    }
}
