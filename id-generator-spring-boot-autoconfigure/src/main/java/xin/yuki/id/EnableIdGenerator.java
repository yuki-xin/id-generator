package xin.yuki.id;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableIdGenerator
 * @author zhang
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({IdGeneratorAutoConfiguration.class})
@Documented
@Inherited
public @interface EnableIdGenerator {
}
