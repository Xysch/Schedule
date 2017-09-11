package com.validator;

import com.entities.Classes;
import com.entities.Students;
import com.services.ClassesService;
import com.services.ProfService;
import com.services.StudGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClassesValidator implements Validator {

    @Autowired
    private ProfService profService;

    @Autowired
    private StudGroupService groupService;

    @Autowired
    private ClassesService classesService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Classes.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Classes classes = (Classes) o;

        if(classes.getProfName() != "" && classes.getProfName()!= null && profService.findByName(classes.getProfName()) == null){
            errors.rejectValue("profName", "NoProf.classesForm.profName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "Required");
        if(classes.getGroupName() != "" && classes.getGroupName()!= null && groupService.findGroupByName(classes.getGroupName()) == null){
            errors.rejectValue("groupName", "NoGroup.classesForm.groupName");
        }

        if (!classesService.findByGroupAndDayAndTime(groupService.findGroupByName(classes.getGroupName()), classes.getDay(), classes.getTime()).isEmpty()){
            errors.rejectValue("time", "TimeTaken.classesForm.time");
        }

        if (!classesService.findByDayAndTimeAndAud(classes.getDay(), classes.getTime(), classes.getAud()).isEmpty()){
            errors.rejectValue("aud", "AudienceBusy.classesForm.aud");
        }

    }
}
