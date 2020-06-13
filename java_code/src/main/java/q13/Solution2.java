package q13;

class Solution2 {
    /*
    把一个小值放在大值的左边，就是做减法，否则为加法。
     */
    public int romanToInt(String s) {
        int result = 0;
        int prevalue = 0;
        int length = s.length();
        for (int i=length - 1; i>=0 ; i--) {
            String currentValue = String.valueOf(s.charAt(i));
            int currentIntValue;
            switch (currentValue){
                case "I" :
                    currentIntValue = 1;
                    break;
                case "V" :
                    currentIntValue = 5;
                    break;
                case "X":
                    currentIntValue = 10;
                    break;
                case "L":
                    currentIntValue = 50;
                    break;
                case "C":
                    currentIntValue = 100;
                    break;
                case  "D":
                    currentIntValue = 500;
                    break;
                case "M":
                    currentIntValue = 1000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + currentValue);
            }

            if (currentIntValue >= prevalue) {
                result += currentIntValue;
            } else {
                result -= currentIntValue;
            }
            prevalue = currentIntValue;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String a = "IV";
        Integer result = s.romanToInt(a);
        System.out.println(result);
    }

}
