package q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] alreadyIndex = new boolean[nums.length];
        backtrack(nums, nums.length, new ArrayList<>(), alreadyIndex);
        return result;
    }

    private void backtrack(int[] nums, int length, List<Integer> currentResult, boolean[] alreadyIndex) {
        if (currentResult.size() == length) {
            result.add(currentResult);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (alreadyIndex[i]) {
                continue;
            }
            // 写 !alreadyIndex[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !alreadyIndex[i - 1]) {
                continue;
            }
            alreadyIndex[i] = true;
            ArrayList<Integer> newCurrentResult = new ArrayList<>(currentResult);
            newCurrentResult.add(nums[i]);
            backtrack(nums, length, newCurrentResult, alreadyIndex);
            alreadyIndex[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 1, 3};
        Solution s = new Solution();
        List<List<Integer>> lists = s.permuteUnique(a);
        System.out.println(lists.toString());
    }
}
