package com.atguigu.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author yangyang
 * @create 2020-11-27-4:07 下午
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {
    String[] value() default "hello";
}
