package test.annotation.test3;

import java.lang.annotation.*;

@Target(ElementType.FIELD) // 用于变量名
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
	boolean primaryKey() default false;

	boolean allowNull() default true;

	boolean unique() default false;
}
