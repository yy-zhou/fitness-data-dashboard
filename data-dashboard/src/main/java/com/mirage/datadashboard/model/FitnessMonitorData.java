package com.mirage.datadashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Definition of constant in project.
 * The following fields was defined:
 * 1. Exchange name for data exchange
 * 2. Data queue name for RabbitMQ
 * 3. Routing key for history consumer (database)
 * 4. Routing key for real time display consumer
 *
 * @author BorisMirage
 * Time: 2019/12/21 13:30
 * Created with IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessMonitorData implements Serializable {
    private Double temperature;
    private Double bloodPressure;
    private Integer heartBeat;
    private Integer stepCount;
    private Date timestamp;
}
