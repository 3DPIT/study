package com.heaven.mvc.heaven;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        return "<h1>show</h1>";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show() {
        return "<h1>show</h1>";
    }
}
