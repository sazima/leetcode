package q11;

class Solution2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (true) {
            int tempResult = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(tempResult, result);
            if (height[left] > height[right]) {
                right --;
            } else {
                left ++;
            }
            if (left >= right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] i = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution2 s = new Solution2();
        System.out.println(s.maxArea(i));
    }
}
