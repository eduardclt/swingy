package za.co.wethinkcode.swingy.controller;

import javax.validation.*;
import javax.validation.constraints.*;
import javax.validation.executable.*;
import org.hibernate.validator.*;
import org.hibernate.*;
import za.co.wethinkcode.swingy.model.characters.Hero;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class ValidatorFactoryController {
    private static Validator	validator;

    public ValidatorFactoryController() {
        final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static boolean runValidator(Hero player) {
        boolean ok;

        ok = true;
        Set<ConstraintViolation<Hero>> validationErrors = validator.validate(player);
        if (!validationErrors.isEmpty()) {
            ok = false;
            for (ConstraintViolation<Hero> error : validationErrors) {
                throw new RuntimeException(error.getPropertyPath().toString() + " :: " + error.getMessage());
            }
        }
        return (ok);
    }
}