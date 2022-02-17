package sword_to_offer.t0217.zi_fu_chuan_de_pai_lie_lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 剑指 Offer 38. 字符串的排列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String s = "abc";

        System.out.println(Arrays.toString(permutation(s)));
    }


    public static String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s,res,new boolean[s.length()],"");
        return res.toArray(new String[0]);
    }

    private static void dfs(String s, List<String> res, boolean[] used, String cur) {
        if(cur.length() == s.length()){
            if(!res.contains(cur)){
                res.add(cur);
            }
            return;
        }

        for(int i = 0; i < s.length(); i++){
            if(!used[i]){
                used[i] = true;
                dfs(s,res,used,cur+s.charAt(i));
                used[i] = false;
            }
        }
    }
}
