package t0103.letter_combinations_of_a_phone_number;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 17. 电话号码的字母组合
 * 中等
 *
 * @author liulin
 */
public class Main {

    public static void main(String[] args) {
        String digits = "2379";
        System.out.println(letterCombinations(digits));
        System.out.println(letterCombinations2(digits));
    }

    /**
     * 个人题解
     * 用两个 ArrayList 存储，空间复杂度高
     * 容易理解
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        Map<Character,List<Character>> map =new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        char[] chars = digits.toCharArray();
        if(chars.length <1) return new ArrayList<>(0);

        List<String> temp = new ArrayList<>();

        for (char aChar : chars) {
            List<Character> characters = map.get(aChar);
            if(result.size()==0){
                for (Character character : characters) {
                    result.add(character.toString());
                }
            }else {
                for (String s : result) {
                    for (Character character : characters) {
                        temp.add(s+character+"");
                    }
                }

                result = temp;
                temp = new ArrayList<>();
            }
        }

        return result;
    }

    // *************** 回溯算法 ***************

    // 数字到号码的映射
    private static String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 路径
    private static StringBuilder sb = new StringBuilder();

    // 结果集
    private static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations2(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits,0);
        return res;
    }

    // 回溯函数
    private static void backtrack(String digits,int index) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index)-'2'];
        for(char ch:val.toCharArray()) {
            sb.append(ch);
            backtrack(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
