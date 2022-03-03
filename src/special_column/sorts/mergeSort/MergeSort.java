package special_column.sorts.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr){
        if(arr.length<2) return arr;

        int mid=arr.length/2;
        int[] left= Arrays.copyOfRange(arr,0,mid);
        int[] right=Arrays.copyOfRange(arr,mid,arr.length);

        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left,int[] right){
        int[] result =new int[left.length+right.length];
        for (int index=0, i = 0,j=0; index < result.length ; index++) {
            if(i>=left.length){
                result[index]=right[j++];
            }else if(j>=right.length){
                result[index]=left[i++];
            }else if(left[i]<right[j]){
                result[index]=left[i++];
            }else result[index]=right[j++];
        }
        return result;
    }
}
