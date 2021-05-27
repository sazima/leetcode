"""
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 

示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"
 

提示：

1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
通过次数255,884提交次数509,732

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""


class Solution:

    def convert(self, s: str, numRows: int) -> str:
        len_s = len(s)
        result = ''
        if numRows == 1:
            return s
        total_step = (numRows - 1) * 2
        for i in range(0, numRows):
            step = 0
            is_first = True
            i_2 = 2 * i
            while i + step < len_s:
                if i == 0 or i == numRows - 1:
                    next_step = total_step
                else:
                    # 第 i 行的step 分两种, 显示 total_step - 2 * i , 2 * i
                    if is_first:
                        next_step = total_step - i_2
                    else:
                        next_step = i_2
                    is_first = not is_first

                result += s[i + step]
                step += next_step
        return result


if __name__ == '__main__':
#     "PAYPALISHIRING"
# 3
# "PAHNALIGYIR"
# 预期结果：
    """
    P   A   H   N
    A P L S I I G
    Y   I   R
    """
# "PAHNAPLSIIGYIR"
    res = Solution().convert('A', 1)
    print(res)
