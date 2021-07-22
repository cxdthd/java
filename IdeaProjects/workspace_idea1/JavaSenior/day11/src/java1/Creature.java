package java1;

import java.io.Serializable;

/**
 * @author YANG
 * @create 2021-05-07 10:23
 */
public class Creature<T> implements Serializable{
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("private权限：生物呼吸");
    }
    public void eat(){
        System.out.println("public权限：生物吃东西");
    }
}
