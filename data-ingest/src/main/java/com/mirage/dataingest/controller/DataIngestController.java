package com.mirage.dataingest.controller;

import com.mirage.dataingest.Constants;
import com.mirage.dataingest.model.FitnessMonitorData;
import com.mirage.dataingest.model.FitnessMonitorRawData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author BorisMirage
 * Time: 2019/12/30 16:39
 * Created with IntelliJ IDEA
 */

public class DataIngestController {

    @Autowired
    private Exchange exchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataIngestController.class);

    @PostMapping("ingest/fitnessdata")  // validate payload from request body
    public FitnessMonitorData ingest(@Valid @RequestBody FitnessMonitorRawData rawData) {
        FitnessMonitorData data = preprocess(rawData);
        rabbitTemplate.convertAndSend(exchange.getName(), Constants.ROUTING_KEY_HISTORY, data);
        rabbitTemplate.convertAndSend(exchange.getName(), Constants.ROUTING_KEY_REALTIME, data);

        LOGGER.info("ingested data: " + data.toString());

        return data;
    }

    private FitnessMonitorData preprocess(FitnessMonitorRawData rawData) {
        FitnessMonitorData data = new FitnessMonitorData();
        data.setBloodPressure(Math.round(rawData.getBloodPressure() * 100.0) / 100.0);
        data.setHeartBeat(rawData.getHeartBeat());
        data.setStepCount(rawData.getStepCount());
        data.setTemperature(Math.round(rawData.getTemperature() * 100.0) / 100.0);
        return data;
    }
}
