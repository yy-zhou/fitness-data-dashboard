package com.mirage.dataingest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Handle raw data with data validity check.
 *
 * @author BorisMirage
 * Time: 2019/12/30 15:09
 * Created with IntelliJ IDEA
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessMonitorRawData {
    @NotNull
    @Min(1)
    @Max(50)
    private Double temperature;

    @NotNull
    @Min(0)
    @Max(300)
    private Double bloodPressure;

    @NotNull
    @Min(0)
    @Max(300)
    private Integer heartBeat;

    @NotNull
    @Min(0)
    @Max(200000)
    private Integer stepCount;
}
