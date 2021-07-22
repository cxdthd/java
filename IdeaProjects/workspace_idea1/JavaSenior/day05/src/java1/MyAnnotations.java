package java1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * @author YANG
 * @create 2021-04-03 12:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
