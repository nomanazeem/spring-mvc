package com.msna.springmvc;

import com.msna.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private LoginService loginService;
    /*@RequestMapping(value = "/login")
    @ResponseBody
    public String sayHello(){
        return "Hello world kkk.";
    }*/



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login_get(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_post(ModelMap modelMap, @RequestParam String user, @RequestParam String password){
        if(loginService.validateUser(user, password)){
            modelMap.put("user", user);
            modelMap.put("password", password);

            return "welcome";
        }else {
            modelMap.put("errorMessage", "Invalid username or password.");

            return "login";
        }
    }

}
