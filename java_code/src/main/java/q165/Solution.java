package q165;

/*
165. 比较版本号
比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

你可以假设版本字符串非空，并且只包含数字和 . 字符。

 . 字符不代表小数点，而是用于分隔数字序列。

例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。


示例 1:

输入: version1 = "0.1", version2 = "1.1"
输出: -1
示例 2:

输入: version1 = "1.0.1", version2 = "1"
输出: 1
示例 3:

输入: version1 = "7.5.2.4", version2 = "7.5.3"
输出: -1
示例 4：

输入：version1 = "1.01", version2 = "1.001"
输出：0
解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
示例 5：

输入：version1 = "1.0", version2 = "1.0.0"
输出：0
解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 */
public class Solution {
    // 1ms 96ms
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version1.split("\\.");
        int size1 = split1.length;
        int size2 = split2.length;
        int index1 = 0;
        int index2 = 0;
        int currentVersion1 = Integer.parseInt(split1[0]);
        int currentVersion2 = Integer.parseInt(split2[0]);
        while (true) {
            if (currentVersion1 > currentVersion2) {
                return 1;
            } else if (currentVersion1 < currentVersion2) {
                return -1;
            } else {
                index1 ++;
                index2 ++;
                if (index1 >= size1 && index2 >= size2) {
                    return 0;
                }
                if (index1 >= size1) {
                    currentVersion1 = 0;
                } else {
                    currentVersion1 = Integer.parseInt(split1[index1]);
                }
                if (index2 >= size2) {
                    currentVersion2 = 0;
                } else {
                    currentVersion2 = Integer.parseInt(split2[index2]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.compareVersion("0.1", "1.1");
        System.out.println(i);

    }
}
