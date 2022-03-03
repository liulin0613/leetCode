package sword_to_offer.t0303.ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu_lcof;

/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 *
 * 剑指 Offer 67. 把字符串转换成整数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String str = "-3147483648";

        System.out.println(strToInt(str));
    }

    public static int strToInt(String str) {
        int len = str.length();
        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < len; i++) {
            if(isSymbol(str.charAt(i))){
                if(startIdx == -1){
                    startIdx = i;
                }else {
                    endIdx = i;
                    break;
                }
            }else if(isNumber(str.charAt(i))){
                startIdx = startIdx == -1? i:startIdx;
                if(i == len - 1) endIdx = len;
            }else {
                if(startIdx != -1){
                    endIdx = i;
                    break;
                }else {
                    if(str.charAt(i) != ' '){
                        return 0;
                    }
                }
            }
        }

        if(endIdx == -1 || (endIdx - startIdx == 1 && isSymbol(str.charAt(startIdx)))){
            return 0;
        }

        try {
            return Integer.parseInt(str.substring(startIdx,endIdx));
        }catch (Exception e){
            return str.charAt(startIdx) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    private static boolean isNumber(char charAt) {
        return charAt >= '0' &&  charAt <= '9';
    }

    private static boolean isSymbol(char charAt) {
        return charAt == '-' || charAt == '+';
    }
}
