package q49;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.rmi.MarshalException;
import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 超时
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String currentString = strs[i];
            boolean insert = false;
            for (int r = 0; r < result.size(); r++) {
                String firstString = result.get(r).get(0);  // 第一个字符串
                if (isSame(firstString, currentString)) {
                    result.get(r).add(currentString);
                    insert = true;
                    break;
                }
            }
            if (!insert) {
                result.add(new ArrayList<>(Collections.singletonList(currentString)));
            }
        }
        return result;
    }

    private boolean isSame(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        return Arrays.equals(b1, b2);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = {"ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo"};
        List<List<String>> r = s.groupAnagrams(a);
        System.out.println(r.toString());

    }
}
