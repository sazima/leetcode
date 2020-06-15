package q43;

public class Solution2 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = len1 + len2;
        int[] result = new int[maxLen];

        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int multi = n1 * n2;
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = multi + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        StringBuilder stringResult = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            stringResult.append(result[i]);
        }
        return stringResult.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String a = "123";
        String b = "456";
        String res = solution2.multiply(a, b);
        System.out.println(res);
    }

}
