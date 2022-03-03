package special_column.sorts.shellSort;

public class ShellSort {
    public static void shellSort(int[] arr){
        int gap = arr.length/2;

        while (gap>0){
            for (int i = 0; i < arr.length; i++) {
                int j=i-gap;
                int value = arr[i];
                for(;j>=0;j-=gap){
                    if(arr[j]>value){
                        arr[j+gap]=arr[j];
                    }else break;
                }

                arr[j+gap]=value;
            }

            gap/=2;
        }
    }
}
