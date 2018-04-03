package com.xianglesong.basic.annotation.reflact;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Inherited;
import java.lang.reflect.Method;

/**
 * Annotation在反射函数中的使用示例
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
}


/**
 * Person类。它会使用MyAnnotation注解。
 */
class Person {

    /**
     * empty()方法同时被 "@Deprecated" 和 “@MyAnnotation(value={"a","b"})”所标注 (01)
     *
     * @Deprecated，意味着empty()方法，不再被建议使用 (02) @MyAnnotation, 意味着empty()
     * 方法对应的MyAnnotation的value值是默认值"unknown"
     */
    @MyAnnotation
    @Deprecated
    public void empty() {
        System.out.println("\nempty");
    }

    /**
     * sombody() 被 @MyAnnotation(value={"girl","boy"}) 所标注，
     *
     * @MyAnnotation(value={"girl","boy" ), 意味着MyAnnotation的value值是{"girl","boy"}
     */
    @MyAnnotation(value = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("\nsomebody: " + name + ", " + age);
    }
}
