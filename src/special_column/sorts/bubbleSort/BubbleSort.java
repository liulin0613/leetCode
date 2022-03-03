package special_column.sorts.bubbleSort;

/**
 * 冒泡排序
 *
 * @author liulin
 */
public class BubbleSort {
    public static void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length -i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }

            if(!swap) break;
        }
    }
}
