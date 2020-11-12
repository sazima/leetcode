package q172;

public class Solution {
    public int trailingZeroes(int n) {
        int lengthN = String.valueOf(n).length();
        double pow = Math.pow(10, lengthN);
        int l = 1;
        int r = n;
        int count = 0;
        long res = 1;
        while (l <= r) {
            if (l == r) {
                res *= r;
            } else {
                res *= l * r;
            }
            while (res % 10 == 0) {
                res /= 10;
                count ++;
            }
            res %= pow;
            l ++;
            r --;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(50));
    }
}
