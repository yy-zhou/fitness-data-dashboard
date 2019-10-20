package com.microsoft.datadashboard.controller;

import com.microsoft.datadashboard.model.dao.DataDAO;
import com.microsoft.datadashboard.model.dvo.DataDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller. Controller is depended on model.
 * REST API.
 *
 * @author BorisMirage
 * Time: 2019/10/20 14:54
 * Created with IntelliJ IDEA
 */

@RestController             // :== @Controller + @ResponseBody
public class DataDashboardController {

    @Autowired
    private DataDAO dataDAO;        // private DataDAO data = new DataHashMapDAO(), if without spring

    /**
     * Hello world.
     * Controller directly send response back to client as JSON by @ResponseBody.
     *
     * @return hello message
     */
    @GetMapping
    public String hello() {
        return "Checking the main page";
    }

    @GetMapping("/data/{id}")
    public DataDVO get(@PathVariable Long id) {
        return dataDAO.findById(id);
    }

    /**
     * Dynamic render the input message to browser.
     *
     * @param name given parameter
     * @return welcome message
     */
    @GetMapping("hello/{name}")
    public String welcome(@PathVariable String name) {
        return "Welcome back, " + name;
    }

    @PostMapping("data")
    public DataDVO createData(@RequestBody DataDVO data) {
        return dataDAO.save(data);
    }
}
