package Stringexer;

/**
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 *
 * @author YANG
 * @create 2021-01-27 21:02
 */

class Two{
    public static String show(String string,int index){
        if (string != null){
            char[] chars = string.toCharArray();
            int i = index;
            int j = string.length() - index - 1;
            while (i < j){
                char team = chars[i];
                chars[i] = chars[j];
                chars[j] = team;
                i++;
                j--;

            }

            return new String(chars);

        }

        return null;

    }
}

public class Exer2 {

    public static void main(String[] args) {
        String s1 = "123456789";
        String show = Two.show(s1, 3);
        System.out.println(show);


    }

}
