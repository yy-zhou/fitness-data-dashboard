package com.mirage.dataconsumer.service;

import com.mirage.dataconsumer.model.FitnessMonitorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author BorisMirage
 * Time: 2019/12/30 17:07
 * Created with IntelliJ IDEA
 */
@Component
public class RuleEngineService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuleEngineService.class);

    public void applyRules(FitnessMonitorData data) {

        // TODO: more triggers and more accurate triggers
        if (data.getBloodPressure() > 120) {
            triggerActionAlert("Your blood pressure may be too high, the reading is " + data.getBloodPressure() + ".");
        }
        if (data.getHeartBeat() > 190) {
            triggerActionAlert("Your heartbeat may be too high, the reading is " + data.getBloodPressure() + ".");
        }
        if (data.getStepCount() < 1000) {
            triggerActionAlert("Today you only walks " + data.getStepCount() + ". What about take a walk?");
        }
        if (data.getTemperature() > 37) {
            triggerActionAlert("Your temperature is unstable, " + data.getTemperature() + ". Go to see doctor.");
        }
    }

    private void triggerActionAlert(String msg) {
        System.out.println("Action Triggered! \n Sending the Email Alert: " + msg + "\n");
        LOGGER.info("Send message " + msg + " to client. ");
    }
}
