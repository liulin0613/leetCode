package special_column.searchs.linearSearch;

public class LinearSearch {
    public static int search(int[] arr, int target){
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
