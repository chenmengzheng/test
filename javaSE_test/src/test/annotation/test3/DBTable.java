package test.annotation.test3;

import java.lang.annotation.*;

/**
 * @author chen
 *
 */
@Target(ElementType.TYPE) // 应用于类、接口、enum、注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	
	public String name() default "";

}
