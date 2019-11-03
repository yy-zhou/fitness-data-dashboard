package com.test.datadashboard.controller;

import com.test.datadashboard.model.dao.DataDAO;
import com.test.datadashboard.model.dvo.DataDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller. Controller is depended on model.
 * REST API.
 *
 * @author BorisMirage
 * Time: 2019/10/20 14:54
 * Created with IntelliJ IDEA
 */
@RestController             // :== @Controller + @ResponseBody
@RequestMapping("api/v1")
public class DataDashboardController {

    @Qualifier("dataJPADAO")
    @Autowired      // dependency injection
    private DataDAO dataDAO;        // private DataDAO data = new DataHashMapDAO(), if without spring

//    @Autowired
//    private Cache cache;


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

    @GetMapping("/data/{id}")
    @Cacheable(value = "dataCache", key = "#id")        // cache name: dataCache, key of cache: id
    public DataDVO getDataById(@PathVariable Long id) {

//        if (cache.get(id) != null) {
//            return cache.get(id);
//        } else {
//            DataDVO tmp = dataDAO.findById(id);
//            cache.put(id, tmp);
//            return tmp;
//        }

        return dataDAO.findById(id);
    }


    /**
     * Get all data based on limit (limit is optional).
     *
     * @param limit optional parameter limits how many data should be displayed at front end
     * @return list of data
     */
    @GetMapping("/data")
    public List<DataDVO> getAllData(@RequestParam(name = "limit", required = false) String limit) {
        return dataDAO.findAll(limit);
    }

    /**
     * Query by data field, value range, then sort them.
     *
     * @return query by data field, value range, then sort them
     */
    @GetMapping("/data/client/{clientId}")
    public List<DataDVO> findDataByClientId(
            @PathVariable Long clientId,
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "start", required = false) String start,
            @RequestParam(name = "end", required = false) String end) {

        return dataDAO.findByClientId(clientId, field, sort, start, end);
    }

    @CachePut(value = "dataCache", key = "#id")
    @PutMapping("/data/{id}")
    public DataDVO putDataById(@PathVariable(name = "id") Long id, @RequestBody DataDVO data) throws Exception {
        DataDVO out = dataDAO.findById(id);
        if (out == null) {
            throw new Exception();
        } else {
            out.setClientId(data.getClientId());
            out.setStepCount(data.getStepCount());
            out.setTemperature(data.getTemperature());
            dataDAO.save(out);
//            cache.put(data.getId(), data);
            return out;
        }
    }
}
