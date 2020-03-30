package q1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap1 = new HashMap<Integer, Integer>();

        for (int i = 0; i< nums.length; i++ ) {
            int currentValue = nums[i];
            if (hashMap1.containsKey(target - currentValue)) {
                return new int[]{hashMap1.get(target - currentValue), i};
            }
            hashMap1.put(currentValue, i);
        }
        return null;
    }

}
