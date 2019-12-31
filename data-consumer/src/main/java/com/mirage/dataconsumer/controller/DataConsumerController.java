package com.mirage.dataconsumer.controller;

import com.mirage.dataconsumer.Constants;
import com.mirage.dataconsumer.model.FitnessMonitorData;
import com.mirage.dataconsumer.repository.FitnessMonitorDataDAO;
import com.mirage.dataconsumer.service.RuleEngineService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author BorisMirage
 * Time: 2019/12/21 13:21
 * Created with IntelliJ IDEA
 */

@Controller
public class DataConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataConsumerController.class);

    @Autowired
    private FitnessMonitorDataDAO fitnessMonitorDataDAO;

    @Autowired
    private RuleEngineService ruleEngineService;

    @RabbitListener(queues = Constants.QUEUE_NAME)
    public void processData(FitnessMonitorData data) {
        LOGGER.info("Received message from MQ '{}", data);

        ruleEngineService.applyRules(data);

        fitnessMonitorDataDAO.save(data);       // save data to database

        LOGGER.info("Saved message to Mongo DB '{}'", data);
        LOGGER.info("Total message saved in Mongo DB is:  " + fitnessMonitorDataDAO.findAll().size());
    }
}
