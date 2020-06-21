package q90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<Integer> currentResult, int start, int[] nums) {
        result.add(currentResult);

        for (int i = start; i < nums.length; i++) {
            ArrayList<Integer> newCurrentResult = new ArrayList<>(currentResult);
            newCurrentResult.add(nums[i]);
            backtrack(newCurrentResult, i + 1, nums);
            while (true) {
                if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(a);
        System.out.println(lists);

    }
}
