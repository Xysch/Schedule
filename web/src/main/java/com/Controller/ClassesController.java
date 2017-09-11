package com.Controller;

import com.entities.Classes;
import com.services.ClassesService;
import com.services.ProfService;
import com.services.StudGroupService;
import com.validator.ClassesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @Autowired
    private ClassesValidator validator;

    @Autowired
    private StudGroupService studGroupService;

    @Autowired
    private ProfService profService;

    private static List<String> days = new LinkedList<>();
    private static List<String> time = new LinkedList<>();

    private List<String> getDays(){
        if(days.size() == 0) {
            days.add("Monday");
            days.add("Tuesday");
            days.add("Wednesday");
            days.add("Thursday");
            days.add("Friday");
            days.add("Saturday");
        }
        return days;
    }

    private List<String> getTime(){
        if(time.size() == 0){
            time.add("9 00");
            time.add("10 40");
            time.add("12 20");
            time.add("14 30");
            time.add("16 10");
            time.add("17 50");
            time.add("19 40");
        }
        return time;
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("classesForm", new Classes());
        model.addAttribute("daysList", getDays());
        model.addAttribute("timeList", getTime());
        return "addclass";
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    public String registration(@ModelAttribute("classesForm") Classes classesForm, BindingResult bindingResult, Model model) {
        validator.validate(classesForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addclass";
        }

        classesService.save(classesForm);

        return "grouplist";
    }

    @RequestMapping(value = { "/edit-class-{id}" }, method = RequestMethod.GET)
    public String editGroupName(@PathVariable Long id, Model model) {
        Classes classesForm = classesService.findById(id);
        classesForm.setGroupName(studGroupService.findById(classesForm.getGroup().getId()).getName());
        try{
            classesForm.setProfName(profService.findById(classesForm.getProf().getId()).getName());
        }
        catch (NullPointerException e){
            classesForm.setProfName("No prof");
        }

        model.addAttribute("daysList", getDays());
        model.addAttribute("timeList", getTime());
        model.addAttribute("classesForm", classesForm);
        return "addclass";
    }

    @RequestMapping(value = { "edit-class-{id}" }, method = RequestMethod.POST)
    public String editGroupName(@ModelAttribute("classesForm") Classes classesForm, BindingResult result, Model model, @PathVariable Long id) {
        validator.validate(classesForm, result);

        if (result.hasErrors()) {
            return "addclass";
        }

        classesService.save(classesForm);

        return "grouplist";
    }


    @RequestMapping(value = { "/delete-class-{id}" }, method = RequestMethod.GET)
    public String deleteClass(@PathVariable Long id) {
        classesService.deleteById(id);

        return "grouplist";
    }




}
