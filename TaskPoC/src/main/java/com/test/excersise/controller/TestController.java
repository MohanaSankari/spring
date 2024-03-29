package com.test.excersise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class TestController {


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello User!";
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String sayHelloPost() {
    	return "Hello User!";
    }

}
