package red.lixiang.tools.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author lixiang
 * @date 2019/12/11
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
public @interface EnhanceTool {
    boolean logParam() default true;
    boolean logResult() default true;
    boolean tryCatch() default true;
}
