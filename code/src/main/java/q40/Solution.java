package q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), 0, target);
        return result;
    }


    private void backtrack(int[] candidates, int start, List<Integer> list, int sum, int target) {
        if (sum == target) {
            this.result.add(list);
        }
        if (sum > target || start >= candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[i]);

            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
                // 1, 2, 2, 3
//                if (candidates[j + 1] == candidates[j]) {
//                    j++;
//                } else {
//                    break;
//                }
            }
            backtrack(candidates, i + 1, newList, sum + candidates[i], target);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int b = 8;
        List<List<Integer>> lists = s.combinationSum2(a, b);
        System.out.println(lists.toString());
    }

}
