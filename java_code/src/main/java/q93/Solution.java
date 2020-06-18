package q93;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Stack;

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

 

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 回溯法
public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(0, new ArrayList<>(), s, s.length());
        return result;
    }

    private void backtrack(int start, List<String> currentResult, String s, int len) {
        // 剩下的是否可以凑成ip地址
        if ((len - 1 - start) > (4 - currentResult.size()) * 3) {
            return;
        }
        // 正常ip
        if (start == len && currentResult.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentResult.size(); i++) {
                if (i == 0)
                    sb.append(currentResult.get(i));
                else
                    sb.append(".").append(currentResult.get(i));
            }
            result.add(sb.toString());
        }

        for (int i = start; i < Math.min(start + 3, len); i++) {
            String ipNum = s.substring(start, i + 1);
            if (Integer.parseInt(ipNum) > 255) {
                continue;
            }
            // 大于1位数时 0不能为头
            if (ipNum.length() > 1 && "0".equals(ipNum.substring(0, 1))) {
                continue;
            }
            currentResult.add(ipNum);
            backtrack(i + 1, currentResult, s, len);
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.restoreIpAddresses("25525511135");
        System.out.println(res);
    }
}
