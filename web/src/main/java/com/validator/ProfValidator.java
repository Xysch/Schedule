package com.validator;

import com.entities.Professors;
import com.entities.StudGroup;
import com.services.ProfService;
import com.services.StudGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfValidator implements Validator {

    @Autowired
    private ProfService profService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Professors.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Professors prof = (Professors) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (profService.findByName(prof.getName()) != null) {
            errors.rejectValue("name", "Prof.profForm.profExists");
        }

    }
}