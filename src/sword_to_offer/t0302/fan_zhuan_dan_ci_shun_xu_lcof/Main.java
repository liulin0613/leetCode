package sword_to_offer.t0302.fan_zhuan_dan_ci_shun_xu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "a good   example";

        System.out.println(reverseWords2(s));
    }

    private static String reverseWords2(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int length = arr.length-1; length >= 0; length--) {
            System.out.println(arr[length]);
            if(arr[length].trim().length() == 0) continue;
            sb.append(arr[length]).append(" ");
        }

        return sb.toString().trim();
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));

        int l = 0, r = arr.length - 1;
        while (l < r){
            while (l < r && arr[l].trim().length() == 0){
                l++;
            }

            while (l < r && arr[r].trim().length() == 0){
                r--;
            }

            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }


        StringBuilder sb = new StringBuilder();
        for (String value : arr) {
            if (value.trim().length() == 0) continue;
            sb.append(value).append(" ");
        }

        return sb.toString().trim();
    }
}
