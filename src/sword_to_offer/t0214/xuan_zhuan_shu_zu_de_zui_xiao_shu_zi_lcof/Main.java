package sword_to_offer.t0214.xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,3,1,3};
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        int l = 0;
        int n = numbers.length-1, r = n;

        while (l<r){
            int mid = l + ((r-l)>>1);
            if(numbers[mid] > numbers[r]){
                l = mid + 1;
            }else if(numbers[mid] < numbers[r]){
                r = mid;
            }else {
                r -= 1; // 忽略右端点
            }
        }

        return numbers[l];
    }
}