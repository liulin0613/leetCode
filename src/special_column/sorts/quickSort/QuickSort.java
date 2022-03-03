package special_column.sorts.quickSort;

public class QuickSort {
    public static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int pivot=partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    private static int partition(int[] arr,int start,int end){
        int low=start,high=end;
        int value = arr[low];

        while (low<high){
            while (low<high && arr[high]>value) high--;
            if(low<high){
                arr[low] = arr[high];
                low++;
            }

            while (low<high && arr[low]<value) low++;
            if(low<high){
                arr[high] = arr[low];
                high--;
            }
        }

        arr[low]=value;
        return low;
    }
}
