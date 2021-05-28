"""

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0
"""

class Solution:
    ## 99%
    def reverse(self, x: int) -> int:
        is_negative = x < 0
        abs_value = abs(x)
        max_value = (2 ** 31) - 1
        result = 0
        while 1:
            result = abs_value % 10 + result * 10
            if is_negative and result >= max_value:
                return 0
            elif not is_negative and result > max_value:
                return 0
            abs_value = abs_value // 10   # 去掉最低位
            if abs_value == 0:
                break
        if is_negative:
            return -result
        return result


if __name__ == '__main__':
    res = Solution().reverse(4321)
    print(res)

