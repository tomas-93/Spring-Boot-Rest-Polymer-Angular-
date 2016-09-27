package com.app.example.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 16/09/2016
 */
@Controller
public class IndexController
{
    @GetMapping(value = "")
    public String  getRedirect()
    {
        return "redirect:/app";
    }

    @GetMapping(value = "/app/**")
    public String getIndex()
    {
        return "forward:/index.html";
    }
}
