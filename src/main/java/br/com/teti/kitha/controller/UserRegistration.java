package br.com.teti.kitha.controller;

import br.com.teti.kitha.dao.UserRepository;
import br.com.teti.kitha.model.User;
import br.com.teti.kitha.model.UserRegistrationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistration {

    private static boolean userRegistrationFailed = false;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userRegistration")
    public String requestUserRegistration(Model user){

        UserRegistrationBean userRegistrationBean = new UserRegistrationBean(userRegistrationFailed);
        user.addAttribute("model", userRegistrationBean);
        userRegistrationFailed = false;
        return "userRegistration";
    }

    @PostMapping("/newUser")
    public ModelAndView requestNewUser(UserRegistrationBean userRegistrationBean){

        User user = new User(userRegistrationBean);
        if(userRepository.findByUserName(user.getUserName()).size() != 0){

            userRegistrationFailed = true;
            return new ModelAndView("redirect:/userRegistration");
        }
        userRepository.save(user);
        userRegistrationFailed = false;
        return new ModelAndView("redirect:/");
    }
}
