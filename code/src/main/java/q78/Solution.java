package q78;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), nums, 0, nums.length);
        return result;
    }

    private void backtrack(List<Integer> currentResult, int[] nums, int start, int len) {
        result.add(currentResult);
        if (start == len) {
            return;
        }
        for (int i = start; i < len; i++) {
            List<Integer> current = new ArrayList<>(currentResult);
            current.add(nums[i]);
            backtrack(current, nums, i + 1, len);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(new int[]{1, 2, 3});
        System.out.println(res);

    }
}
