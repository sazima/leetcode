package q3;

import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> strings = new ArrayList<String>();
        int l = s.length();
        for (int i =0; i<l; i++) {
            String currentValue = Character.toString(s.charAt(i));
            if (s.indexOf(currentValue) != i) {
                return i;
            }
        }
        return s.length();
    }
}
