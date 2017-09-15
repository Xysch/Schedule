package com.Controller;

import Comparator.TimeComparator;
import com.entities.*;
import com.services.ClassesService;
import com.services.StudGroupService;
import com.services.UserService;
import com.validator.EditUserValidator;
import com.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private EditUserValidator editValidator;

    @Autowired
    private StudGroupService groupService;

    @Autowired
    private ClassesService classesService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Students());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Students userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/students";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }



    @RequestMapping(value = { "/edit-user-{username}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String username, Model model) {
        Students user = userService.findByUsername(username);
        try {
            user.setGroupName(userService.getGroupById(user.getGroup().getId()).getName());
        }
        catch (NullPointerException e){
            user.setGroupName("");
        }
        user.setConfirmPassword(user.getPassword());
        model.addAttribute("user", user);
        return "edit";
    }


    @RequestMapping(value = { "/edit-user-{username}" }, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") Students user, BindingResult result, Model model, @PathVariable String username) {
        editValidator.validate(user, result);

        if (result.hasErrors()) {
            return "edit";
        }


        userService.updateUser(user);

        return "redirect:/students";
    }



    @RequestMapping(value = { "/delete-user-{username}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username) {
        userService.deleteByUsername(username);
        return "redirect:/students";
    }


    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


    @RequestMapping(value = "/students" , method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<Students> users = userService.findAll();
        Students admin = new Students();
        int i=1;
        for(Students stud: users){
            if(i==1){
                if(stud.getUsername().equals("admin")){
                    admin = stud;
                    i--;
                }
            }
            try{
                StudGroup grp = stud.getGroup();
                Long id = grp.getId();
                grp = userService.getGroupById(id);
                String name = grp.getName();
                stud.setGroupName(name);
            }
            catch (NullPointerException e){
                stud.setGroupName("No group");
            }
        }
        users.remove(admin);
        model.addAttribute("users", users);
        return "students";
    }

    @RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
    public String editGroup(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        try {
            StudGroup group = groupService.findById(userService.findByUsername(username).getGroup().getId());
            TimeComparator timeComparator = new TimeComparator();
            List<Classes> classesMonday = classesService.findByGroupAndDay(group, "Monday");
            Collections.sort(classesMonday, timeComparator);
            List<Classes> classesTuesday = classesService.findByGroupAndDay(group, "Tuesday");
            Collections.sort(classesTuesday, timeComparator);
            List<Classes> classesWednesday = classesService.findByGroupAndDay(group, "Wednesday");
            Collections.sort(classesWednesday, timeComparator);
            List<Classes> classesThursday = classesService.findByGroupAndDay(group, "Thursday");
            Collections.sort(classesThursday, timeComparator);
            List<Classes> classesFriday = classesService.findByGroupAndDay(group, "Friday");
            Collections.sort(classesFriday, timeComparator);
            List<Classes> classesSaturday = classesService.findByGroupAndDay(group, "Saturday");
            Collections.sort(classesSaturday, timeComparator);

            model.addAttribute("mondayClasses", classesMonday);
            model.addAttribute("tuesdayClasses", classesTuesday);
            model.addAttribute("wednesdayClasses", classesWednesday);
            model.addAttribute("thursdayClasses", classesThursday);
            model.addAttribute("fridayClasses", classesFriday);
            model.addAttribute("saturdayClasses", classesSaturday);
        }
        catch (NullPointerException e){
            
        }

        return "userpage";
    }


}