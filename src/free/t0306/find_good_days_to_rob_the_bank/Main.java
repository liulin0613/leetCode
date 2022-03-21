package free.t0306.find_good_days_to_rob_the_bank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 *
 * 2100. 适合打劫银行的日子
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] security = {5,3,3,3,5,6,2};
        int time = 2;

        System.out.println(goodDaysToRobBank(security, time));
        System.out.println(goodDaysToRobBank2(security, time));
    }

    private static List<Integer> goodDaysToRobBank2(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int len = security.length;
        if(time == 0){
            for (int i = 0; i < len; i++){
                res.add(i);
            }

            return res;
        }

        int[] leftLen = new int[len];
        leftLen[0] = 0;
        for(int i = 1; i < len; i++){
            leftLen[i] = (security[i] <= security[i-1] ? leftLen[i-1] + 1 : 0);
        }

        int rightLen = 0;
        for(int i = len - 2; i >= 0 ; --i){
            rightLen = security[i] <= security[i+1] ? rightLen + 1 : 0;

            if(Math.min(rightLen,leftLen[i]) >= time){
                res.add(0,i);
            }
        }
        return res;
    }

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int len = security.length;
        if(time == 0){
            for (int i = 0; i < len; i++){
                res.add(i);
            }

            return res;
        }

        for(int i = time; i + time < len; i++){
            if(adjustLeft(security,i - time,i) && adjustRight(security,i, i + time)){
                res.add(i);
            }
        }

        return res;
    }

    private static boolean adjustRight(int[] security, int left, int right) {
        for(int i = left; i < right; ++i){
            if(security[i] > security[i+1]){
                return false;
            }
        }
        return true;
    }

    private static boolean adjustLeft(int[] security, int left, int right) {
        for(int i = left; i < right; ++i){
            if(security[i] < security[i+1]){
                return false;
            }
        }
        return true;
    }
}
