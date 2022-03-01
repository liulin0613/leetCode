package sword_to_offer.t0301.ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * 剑指 Offer 46. 把数字翻译成字符串
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int num = 1402;
//        int num = 220;
        System.out.println(translateNum(num));
    }

    static int res = 0;
    public static int translateNum(int num) {
        backtrack(String.valueOf(num),0);
        return res;
    }

    private static void backtrack(String num,int cur) {
        if(cur == num.length()){
            res++;
            return;
        }

        int j = cur + 1;
        while (j <= num.length()){
            int value = Integer.parseInt(num.substring(cur,j));

            // 处理前导 0 比如 06
            if(j > cur + 1 && num.charAt(cur) == '0'){
                j++;
                continue;
            }

            System.out.println(value);
            if(value <= 25 && value >= 0){
                backtrack(num,j);
            }

            j++;
        }
    }
}
