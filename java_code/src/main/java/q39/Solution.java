package q39;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    /*
        执行用时 :
    3 ms
    , 在所有 Java 提交中击败了
    92.53%
    的用户
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            backtrack(candidates, i, newList, sum + candidates[i], target);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2, 3, 6, 7};
        int b = 7;
        List<List<Integer>> lists = s.combinationSum(a, b);
        System.out.println(lists.toString());
    }
}

