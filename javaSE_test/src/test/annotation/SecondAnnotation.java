package test.annotation;

import java.lang.annotation.Documented;   
import java.lang.annotation.ElementType;   
import java.lang.annotation.Retention;   
import java.lang.annotation.RetentionPolicy;   
import java.lang.annotation.Target;   
  
@Documented   
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.METHOD)   
public @interface SecondAnnotation {   
//  注释中含有两个参数   
    String name() default "Hrmzone";   
    String url() default "hrmzone.cn";   
  
}   