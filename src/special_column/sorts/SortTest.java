package special_column.sorts;

import special_column.sorts.heapSort.HeapSort;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random()*1000);
        }

        //   ========================================================
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
