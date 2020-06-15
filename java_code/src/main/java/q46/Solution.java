package q46;

import javax.activation.MailcapCommandMap;
import java.util.ArrayList;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new ArrayList<>());
        return result;
    }
    private void backtrack(int[]nums, List<Integer> currentResult, List<Integer> alreadyIndex) {
        if (currentResult.size() == nums.length) {
            result.add(currentResult);
            return;
        }
        for (int i =0; i<nums.length; i++) {
            if (alreadyIndex.contains(i)) {
                continue;
            }
            ArrayList<Integer> newCurrentResult = new ArrayList<>(currentResult);
            newCurrentResult.add(nums[i]);
            ArrayList<Integer> newAlreadyIndex = new ArrayList<>(alreadyIndex);
            newAlreadyIndex.add(i);
            backtrack(nums, newCurrentResult, newAlreadyIndex);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 2, 3};
        List<List<Integer>> permute = s.permute(a);
        System.out.println(permute.toString());
    }
}
