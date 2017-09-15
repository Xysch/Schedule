package com.Controller;


import com.entities.Classes;
import com.entities.Professors;
import com.entities.StudGroup;
import com.entities.Students;
import com.services.ClassesService;
import com.services.ProfService;
import com.services.StudGroupService;
import com.services.UserService;
import com.validator.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private GroupValidator validator;

    @Autowired
    private StudGroupService service;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private ProfService profService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addgroup", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("groupForm", new StudGroup());

        return "addgroup";
    }

    @RequestMapping(value = "/addgroup", method = RequestMethod.POST)
    public String registration(@ModelAttribute("groupForm") StudGroup groupForm, BindingResult bindingResult, Model model) {
        validator.validate(groupForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addgroup";
        }


        service.save(groupForm);

        return "redirect:/grouplist";
    }

    @RequestMapping(value = "/grouplist" , method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<StudGroup> groups = service.findAll();

        model.addAttribute("groups", groups);
        return "grouplist";
    }


    @RequestMapping(value = { "/classeslist-{name}" }, method = RequestMethod.GET)
    public String editGroup(@ModelAttribute("name") String name , Model model) {
        List<Classes> classes = classesService.findByGroup(service.findGroupByName(name));
        for(Classes classes1: classes){
            try {
                Professors prof = profService.findById(classes1.getProf().getId());
                classes1.setProfName(prof.getName());
            }
            catch (NullPointerException e){
                classes1.setProfName("No prof");
            }
            try {
                StudGroup grp = service.findById(classes1.getGroup().getId());
                classes1.setGroupName(grp.getName());
            }
            catch (NullPointerException e){
                classes1.setGroupName("No group");
            }
        }

        model.addAttribute("classes", classes);
        return "classeslist";
    }

    @RequestMapping(value = { "/edit-groupname-{id}" }, method = RequestMethod.GET)
    public String editGroupName(@PathVariable Long id, Model model) {
        StudGroup groupForm = service.findById(id);


        model.addAttribute("groupForm", groupForm);
        return "addgroup";
    }

    @RequestMapping(value = { "/edit-groupname-{id}" }, method = RequestMethod.POST)
    public String editGroupName(@ModelAttribute("groupForm") StudGroup groupForm, BindingResult result, Model model, @PathVariable Long id) {
        List<Classes> classesList = classesService.findByGroup(service.findById(groupForm.getId()));
        List<Students> studentsList = userService.findAllByGroup(service.findById(groupForm.getId()));
        validator.validate(groupForm, result);

        if (result.hasErrors()) {
            return "addgroup";
        }

        service.save(groupForm);
        for(Classes cls : classesList){
            cls.setGroup(service.findById(groupForm.getId()));
        }
        for (Students stud : studentsList){
            stud.setGroup(service.findById(groupForm.getId()));
        }
        userService.save(studentsList);
        classesService.save(classesList);

        return "redirect:/grouplist";
    }




    @RequestMapping(value = { "/delete-group-{name}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String name) {
        service.deleteByName(name);
        return "redirect:/grouplist";
    }




}
