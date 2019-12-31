package com.mirage.dataingest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BorisMirage
 * Time: 2019/12/30 15:09
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
