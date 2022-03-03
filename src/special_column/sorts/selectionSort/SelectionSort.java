package special_column.sorts.selectionSort;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_index = i;

            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<min){
                    min=arr[j];
                    min_index=j;
                }
            }

            if(min_index!=i){
                int temp =arr[min_index];
                arr[min_index]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
