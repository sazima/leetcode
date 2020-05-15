package q49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (int i =0; i<strs.length; i++) {
            String currentString = strs[i];
            char[] chars = currentString.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (resultMap.containsKey(sortedString)) {
                resultMap.get(sortedString).add(currentString);
            } else {
                ArrayList<String> l = new ArrayList<>();
                l.add(currentString);
                resultMap.put(sortedString, l);
            }
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
//        String[] a = {"ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo"};
        String[] a = {"fet", "eft", "b"};
        Solution2 s = new Solution2();
        List<List<String>> res = s.groupAnagrams(a);
        System.out.println(res.toString());

    }
}
