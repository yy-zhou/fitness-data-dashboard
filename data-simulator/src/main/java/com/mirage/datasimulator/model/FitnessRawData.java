package com.mirage.datasimulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Raw data format.
 *
 * @author BorisMirage
 * Time: 2019/12/22 12:44
 * Created with IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessRawData implements Serializable {
    private Double temperature;
    private Double bloodPressure;
    private Integer heartBeat;
    private Integer stepCount;
}
