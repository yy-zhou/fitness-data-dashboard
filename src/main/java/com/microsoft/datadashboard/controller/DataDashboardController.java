package com.microsoft.datadashboard.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Controller.
 *
 * @author BorisMirage
 * Time: 2019/10/20 14:54
 * Created with IntelliJ IDEA
 */

@RestController             // bind as a controller, equals as @Controller + @ResponseBody
public class DataDashboardController {
    /**
     * Hello world.
     *
     * @return hello message
     */
//    @RequestMapping(method = RequestMethod.GET)     // bind a router to current controller
    @GetMapping
//    @ResponseBody       // controller directly send response back to client as JSON
    public String hello() {
        return "Checking the main page";
    }

    /**
     * Dynamic render the input message to browser.
     *
     * @param name given parameter
     * @return welcome message
     */
//    @RequestMapping(value = "hello/{name}", method = RequestMethod.GET)
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String welcome(@PathVariable String name) {
        return "Welcome back, " + name;
    }
}
