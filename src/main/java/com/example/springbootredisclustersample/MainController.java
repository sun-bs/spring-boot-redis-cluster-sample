package com.example.springbootredisclustersample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {

    private final HttpSession httpSession;

    private final static String SESSION_KEY = "key";

    @Autowired
    public MainController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    /**
     * save value to redis session.
     */
    @GetMapping("/set-session/{value}")
    @ResponseBody
    public String setValueToRedis(@PathVariable("value") String value) {
        httpSession.setAttribute(SESSION_KEY, value);
        return "OK";
    }

    /**
     * get value from redis session.
     */
    @GetMapping("/get-session")
    @ResponseBody
    public String getValueFromRedis() {
        String value = (String) httpSession.getAttribute(SESSION_KEY);
        return value == null ? "none" : value;
    }
}
