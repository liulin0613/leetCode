package free.t0317.find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        System.out.println(findAnagrams2(s, p));
    }

    private static List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] chs = p.toCharArray();
        Arrays.sort(chs);
        String key = new String(chs);

        int len = p.length();

        List<Integer> res = new ArrayList<>();

        for(int idx = 0; idx <= s.length() - len; ++idx){
            String cur = s.substring(idx,idx + len);
            char[] curs = cur.toCharArray();
            Arrays.sort(curs);

            if(new String(curs).equals(key)){
                res.add(idx);
            }
        }

        return res;
    }
}
