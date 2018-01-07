package br.com.teti.kitha.controller;

import br.com.teti.kitha.dao.UserRepository;
import br.com.teti.kitha.model.LoginBean;
import br.com.teti.kitha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Index {

    private static boolean loginFailed = false;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(Model user){

        LoginBean loginBean = new LoginBean(loginFailed);
        user.addAttribute("model", loginBean);
        loginFailed = false;
        return "index";
    }

    @PostMapping("/logInto")
    public ModelAndView logInto(LoginBean loginBean){

        User user = new User(loginBean);
        if(userRepository.findByLogin(user).size() != 0){

            loginFailed = false;
            return new ModelAndView("redirect:/home");
        }
        loginFailed = true;
        return new ModelAndView("redirect:/");
    }
}
