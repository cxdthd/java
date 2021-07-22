package Stringexer;

/**
 * 3.获取一个字符串在另一个字符串中出现的次数。
 *       比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
 *       中出现的次数
 *
 * @author YANG
 * @create 2021-01-28 19:02
 */
class Three{
    public static int show(String str,String string){
        int total = 0;
        int index = 0;
        if(str.length() <= string.length()){
            while ((index = string.indexOf(str)) != -1){
                total++;
                string = string.substring(index + str.length());
            }


        }else{
            return 0;
        }

        return total;
    }
}

public class Exer3 {
    public static void main(String[] args) {
        String str = "ab";
        String string = "cdabkkcadkabkebfkabkskab";
        int i = Three.show(str, string);
        System.out.println(i);  //4
    }
}
