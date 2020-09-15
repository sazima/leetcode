package q168;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            n--;
            int i = n % 26;
            result.append((char) ('A' + i));;
            n /= 26;
        }
        return result.reverse().toString();

    }
}
