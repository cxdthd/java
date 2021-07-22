package java0;

public class StringTest {
    public static void main(String[] args) {
        String str0 = null;
        String str = "     abc   cde s   ";
        String s = StringTool.simulateTrim(str);
        System.out.println("---" + s + "---");  //---abc   cde s---
        String s1 = StringTool.simulateTrim(str0);
        System.out.println(s1); //null

        System.out.println("**************************************************");

        String string = "abcdefghijklmn";
        String s2 = StringTool.simulateReversal(string, 3, 7);
        System.out.println(s2); //abchgfedijklmn

        System.out.println("*****************************************************");

        String s3 = "abkkcadkabkebfkabkskab";
        String s4 = "ab";
        int i = StringTool.method3(s3, s4);
        System.out.println(i);  //4

        System.out.println("******************************************************");

    }
}

class StringTool {

    //模拟一个trim方法，去除字符串两端的空格
    public static String simulateTrim(String str) {
        if (str == null) {
            return null;
        }
        String string = null;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                string = str.substring(i);
                break;
            }
        }
        char[] chars1 = string.toCharArray();
        for (int i = chars1.length - 1; i > 0; i--) {
            if (chars1[i] != ' ') {
                string = string.substring(0, i + 1);
                break;
            }
        }

        return string;
    }

    //    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg”
    public static String simulateReversal(String string, int start, int end) {
        if (start > end) {
            throw new RuntimeException("输入的start必须不大于end！！！！");
        }

        if (string == null | start == end) {
            return string;
        }

        char[] chars = string.toCharArray();
        while (true) {
            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            } else {
                break;
            }
        }
        return new String(chars);
    }

    //获取一个字符串在另一个字符串中出现的次数。
    // 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数

    /**
     *
     * @param subjectString
     * @param subString
     * @return
     */
    public static int method3(String subjectString, String subString) {
        if (subjectString.length() < subString.length()) {
            return 0;
        }

        int total = 0;
        while (true) {
            int i = subjectString.indexOf(subString);
            if (i >= 0) {
                total++;
                String substring = subjectString.substring(i + subString.length());
                subjectString = substring;
            } else {
                break;
            }
        }


        return total;
    }

    //获取两个字符串中最大相同子串。比如： str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    //提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    public static String maxString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }

        String shortString = (str1.length() >= str2.length()) ? str2 : str1;
        String longString = (str1.length() > str2.length()) ? str1 : str2;

        int length = shortString.length();

        for (int i = 0;i < length;i++){

        }

        return null;
    }
}
