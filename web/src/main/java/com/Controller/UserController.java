package com.Controller;

import com.dao.StudGroupDao;
import com.entities.StudGroup;
import com.entities.Students;
import com.services.UserService;
import com.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

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

        return "registration";
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



    @RequestMapping(value = { "/edit-user-{userForm}" }, method = RequestMethod.GET)
    public String editUser(@ModelAttribute("userForm") Students userForm, Model model) {
        Students user = userService.findByUsername(userForm.getUsername());
        model.addAttribute("student", user);
        return "registration";
    }


    @RequestMapping(value = { "/edit-user-{userForm}" }, method = RequestMethod.POST)
    public String updateUser(@Valid Students userForm, BindingResult result,
                             ModelMap model) {

        if (result.hasErrors()) {
            return "update";
        }

        userService.updateUser(userForm);

        model.addAttribute("success", "User " + userForm.getfName() + " " + userForm.getlName() + " updated successfully");
        return "registration";
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
        for(Students stud: users){
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
        model.addAttribute("users", users);
        return "students";
    }
}