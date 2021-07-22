package Stringexer;

/**
 * 模拟一个trim方法，去除字符串两端的空格。
 *
 * @author YANG
 * @create 2021-01-27 20:44
 */



class A{
    public static String show(String string){
        if (string == null){
            return null;
        }
        String substring = null;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' '){
                substring = string.substring(i);
                break;
            }
        }
        char[] chars1 = substring.toCharArray();
        for (int i = chars1.length -1; i > 0 ; i--) {
            if (chars1[i] != ' '){
                substring = substring.substring(0,i + 1);
                break;
            }
        }

        return substring;

    }
}

public class Exer1 {
    public static void main(String[] args) {
        String s1 = "   a b c  eeeeeeee   ";
        String show = A.show(s1);
        System.out.println("---" + show + "---");   //---a b c---

        String s2 = "abc";
        String show2 = A.show(s2);
        System.out.println("---" + show2 + "---");   //---abc---

        String s3 = null;
        String show1 = A.show(s3);
        System.out.println(show1);
    }
}
