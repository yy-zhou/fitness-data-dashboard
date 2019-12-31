package com.mirage.dataconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BorisMirage
 * Time: 2019/12/30 17:29
 * Created with IntelliJ IDEA
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "healthdata")
public class FitnessMonitorData implements Serializable {
    private Double temperature;
    private Double bloodPressure;
    private Integer heartBeat;
    private Integer stepCount;
    private Date timestamp;
}
