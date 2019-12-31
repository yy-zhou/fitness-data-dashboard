package com.mirage.datadashboard.controller;

import com.mirage.datadashboard.Constants;
import com.mirage.datadashboard.model.FitnessMonitorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;


/**
 * @author BorisMirage
 * Time: 2019/12/30 17:56
 * Created with IntelliJ IDEA
 */

public class WebSocketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = Constants.QUEUE_NAME)      // subscribe to MQ
    public void sendRealTimeData(FitnessMonitorData data) {
        LOGGER.info("Received message from MQ '{}'", data);
        simpMessagingTemplate.convertAndSend("/topic/realtime", data.toString());
    }
}
