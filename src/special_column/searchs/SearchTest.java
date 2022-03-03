package special_column.searchs;

import special_column.searchs.binarySearch.BinarySearch;
import special_column.searchs.leftOrRightSearch.LeftOrRightSearch;
import special_column.searchs.linearSearch.LinearSearch;
import special_column.searchs.quickSelect.QuickSelect;

public class SearchTest {
    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= i*2;
        }

        System.out.println(LinearSearch.search(arr, 10));
        System.out.println(BinarySearch.search(arr, 10));

        int[] brr = {1,2,3,3,3,3,3,4,5,6};
        System.out.println(LeftOrRightSearch.findLeft(brr, 3));
        System.out.println(LeftOrRightSearch.findRight(brr, 3));

        System.out.println(QuickSelect.select(brr, 5));
    }
}
