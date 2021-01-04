package com.modex.employeesdepartment.Controller;

import com.modex.employeesdepartment.Config.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        getLogger();
        return modelAndView;

    }



    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        getLoggerHome();
        return modelAndView;


    }


    final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    public Logger getLogger() {
        logger.debug("Employee is logging in!");
        logger.info("Employee is on the Website");
        return logger;
    }

    public Logger getLoggerHome() {
        logger.debug("Employee has Logged in");
        logger.info("Employee is on iKub Dashboard");
        return logger;
    }






}
