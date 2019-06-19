package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author felix.ou
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SqlInjectValidator.class)
public @interface NotSQLInject {
    String message() default "该参数不允许SQL注入的输入";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
