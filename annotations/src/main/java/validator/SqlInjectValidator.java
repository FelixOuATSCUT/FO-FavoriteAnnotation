package validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author felix.ou
 */
public class SqlInjectValidator implements ConstraintValidator<NotSQLInject, String> {
    private static String regSQLInject = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
            + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute|>|<|=)\\b)";

    Pattern sqlPattern = Pattern.compile(regSQLInject, Pattern.CASE_INSENSITIVE);

    public void initialize(NotSQLInject notSQLInject) {
    }

    // @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return !sqlPattern.matcher(value).find();
    }
}
