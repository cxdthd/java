package java1;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author YANG
 * @create 2021-04-03 0:30
 */
//jdk8之前：
//@MyAnnotations({@MyAnnotation("fl"),@MyAnnotation("fl2")})
//jdk8之后：
@MyAnnotation("fl")
@MyAnnotation("fl2")
public class AnnotationTest {
    @Test
    public void test() {
        Class sClass = s.class;
        Annotation[] annotations = sClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

class s extends AnnotationTest {

}

class Dog<@MyAnnotation T> {

}



