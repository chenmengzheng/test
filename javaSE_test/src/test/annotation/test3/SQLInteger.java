package test.annotation.test3;

import java.lang.annotation.*;

@Target(ElementType.FIELD) // FIELD 用于变量名
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {

	String name() default "";

	Constraints constraints() default @Constraints
	;
}
