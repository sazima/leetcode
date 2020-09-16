package q169;

import java.util.HashMap;
import java.util.Map;

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : nums) {
            Integer count = countMap.getOrDefault(i, 0);
            countMap.put(i, count + 1);
            if (count + 1 > len / 2) {
                return i;
            }
        }
        return 0;

    }
}