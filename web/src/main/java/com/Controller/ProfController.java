package com.Controller;

import com.entities.Professors;
import com.entities.StudGroup;
import com.services.ProfService;
import com.validator.ProfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfController {


    @Autowired
    ProfService profService;

    @Autowired
    ProfValidator profValidator;

    @RequestMapping(value = "/addprof", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("profForm", new Professors());

        return "addprof";
    }

    @RequestMapping(value = "/addprof", method = RequestMethod.POST)
    public String registration(@ModelAttribute("profForm") Professors profForm, BindingResult bindingResult, Model model) {
        profValidator.validate(profForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addprof";
        }

        profService.save(profForm);

        return "admin";
    }
}
