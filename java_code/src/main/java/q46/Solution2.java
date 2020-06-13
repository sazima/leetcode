package q46;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remainNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(nums.length, remainNums, 0);
        return result;
    }
    private void backtrack(int length, List<Integer> output, int first) {
        if (first == length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i =first; i<output.size(); i++) {
            Collections.swap(output, first, i);  // 交换
            backtrack(length, output, first + 1);
            Collections.swap(output, first, i);

        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] a = {1, 2, 3};
        List<List<Integer>> re = solution2.permute(a);
        System.out.println(re.toString());

    }

}
