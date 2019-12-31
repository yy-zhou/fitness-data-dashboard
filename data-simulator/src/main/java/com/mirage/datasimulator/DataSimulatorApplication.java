package com.mirage.datasimulator;

import com.mirage.datasimulator.model.FitnessRawData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


@SpringBootApplication
public class DataSimulatorApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSimulatorApplication.class);
    private static final String RESOURCE_URL = "http://localhost:9001/ingest/healthdata";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final Random RANDOM = new Random();
    private static final double MIN_VALUE = 10;
    private static final double MAX_VALUE = 30;
    private static final Timer TIMER = new Timer();
    private static final int INTERVAL = 1000;

    public static void main(String[] args) {
        SpringApplication.run(DataSimulatorApplication.class, args);
        TIMER.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                FitnessRawData payload = new FitnessRawData(generateRandomValue(), generateRandomValue(), (int) generateRandomValue(), (int) generateRandomValue());

                HttpEntity<FitnessRawData> req = new HttpEntity<>(payload);
                REST_TEMPLATE.postForObject(RESOURCE_URL, req, Object.class);
                LOGGER.info("POST to: " + RESOURCE_URL);
                LOGGER.info("Request content: " + req.toString());
            }
        }, 0, INTERVAL);
    }

    private static double generateRandomValue() {
        int randInt = RANDOM.nextInt(5);
        if (randInt == 0) {
            return 99;
        } else {
            return MIN_VALUE + RANDOM.nextDouble() * (MAX_VALUE - MIN_VALUE);
        }
    }
}
