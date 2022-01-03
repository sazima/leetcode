"""
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
"""
from typing import List


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        # right_index = 1
        if num2 == '0' or num1 == '0':
            return '0'
        ord_0 = ord('0')
        line_results = []  # type: List[str]  # 记录每一位乘的结果
        for index, i in enumerate(num1[::-1]):
            line_result = "0" * index
            num1_value = ord(i) - ord_0
            zeng = 0
            for j in num2[::-1]:
                num2_value = ord(j) - ord_0

                num1_multi_num2 = num1_value * num2_value
                num1_multi_num2 += zeng

                zeng = num1_multi_num2 // 10
                v = num1_multi_num2 % 10
                line_result += str(v)
            if zeng:
                line_result += str(zeng)
            line_results.append(line_result)

        # 把每一位乘的结果 加起来
        index = 0
        result = ""
        zeng = 0
        while True:
            dangge_jia_value = 0
            index_flag = False
            for line in line_results:
                if index < len(line):
                    index_flag = True
                    value = ord(line[index]) - ord_0
                else:
                    value = 0
                dangge_jia_value += value
            dangge_jia_value += zeng
            if not index_flag:
                break
            zeng = dangge_jia_value // 10
            v = dangge_jia_value % 10
            result += str(v)
            index += 1
        if zeng:
            result += str(zeng)
        return result[::-1]

        # while True:
        #
        #     num2_value = ord(num2[len(num2) - right_index]) - ord('0')
if __name__ == '__main__':
    res = Solution().multiply("408", "5")
    print(res)