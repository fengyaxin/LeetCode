import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 **/
public class code13_S {
    public static void main(String[] args) {
        String s = "IX";
        System.out.println(romanToInt2(s));

    }

    //
    public static int romanToInt(String s) {

        int num = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I' && i + 1 < s.length() || s.charAt(i) == 'C' && i + 1 < s.length() || s.charAt(i) == 'X' && i + 1 < s.length()) {
                String temp = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
                if (temp.equals("IV") || temp.equals("IX") || temp.equals("XL") || temp.equals("XC") || temp.equals("CD") || temp.equals("CM")) {
                    num += map.get(temp);
                    i++;
                    continue;
                }
            }
            num += map.get(String.valueOf(s.charAt(i)));
        }
        return num;
    }


    //从后往前读每个字符，如果获取的字符值比前一个字符值小，就将该值相减；否则，相加
    public static int romanToInt2(String s) {
        Map<Character, Integer> a = new HashMap<Character, Integer>();
        a.put('I', 1);
        a.put('V', 5);
        a.put('X', 10);
        a.put('L', 50);
        a.put('C', 100);
        a.put('D', 500);
        a.put('M', 1000);
        int sum = 0;
        int pre = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int val = a.get(s.charAt(i));
            if (pre > val) {
                sum -= val;
            } else {
                sum += val;
            }
            pre = val;
        }
        return sum;
    }

    //从前往后读
    public static int romanToInt3(String s) {
        Map<Character, Integer> a = new HashMap<Character, Integer>();
        a.put('I', 1);
        a.put('V', 5);
        a.put('X', 10);
        a.put('L', 50);
        a.put('C', 100);
        a.put('D', 500);
        a.put('M', 1000);
        int sum = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = a.get(s.charAt(i));
            if (pre < value) {
                sum = sum + value - 2 * pre;
            } else {
                sum = sum + value;
            }
            pre = value;
        }
        return sum;
    }


    //switch 比 hashmap效率高
    public int romanToInt4(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
