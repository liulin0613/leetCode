package t0104.group_anagrams;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 49. 字母异位词分组
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 排序
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0){
            return result;
        }

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String res = sort(str);
            if(map.containsKey(res)){
                map.get(res).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(res,list);
            }
        }

        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

    private static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    /**
     * 分拣存储，超出时间限制
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0){
            return result;
        }

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            boolean isAna = false;
            for (String s : map.keySet()) {
                if(isAnagrams(s,str)){
                    map.get(s).add(str);
                    isAna = true;
                    break;
                }
            }

            if(!isAna){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str,list);
            }
        }

        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;

    }

    private static boolean isAnagrams(String s, String str) {
        List<Character> set = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if(!set.contains(str.charAt(i))){
                return false;
            }else {
                set.remove(Character.valueOf(str.charAt(i)));
            }
        }

        return set.isEmpty();
    }

}
