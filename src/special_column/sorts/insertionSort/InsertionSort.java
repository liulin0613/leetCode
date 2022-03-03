package special_column.sorts.insertionSort;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr.length<=1) return;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(arr[j]>value){
                    arr[j+1]=arr[j];
                }else break;
            }

            arr[j+1]=value;
        }
    }
}
