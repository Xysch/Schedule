package com.validator;


import com.entities.StudGroup;
import com.services.StudGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class GroupValidator implements Validator {

    @Autowired
    private StudGroupService groupService;

    @Override
    public boolean supports(Class<?> aClass) {
        return StudGroup.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StudGroup group = (StudGroup) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (groupService.findGroupByName(group.getName()) != null) {
            errors.rejectValue("name", "Group.Already.Exists");
        }

    }
}
