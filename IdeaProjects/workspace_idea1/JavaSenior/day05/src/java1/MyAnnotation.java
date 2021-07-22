package java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;

/**
 * @author YANG
 * @create 2021-04-03 10:33
 */
//@Inherited
@Repeatable(MyAnnotations.class)       //可重复的
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,TYPE_PARAMETER})
public @interface MyAnnotation {
    String value() default "hello";
}


