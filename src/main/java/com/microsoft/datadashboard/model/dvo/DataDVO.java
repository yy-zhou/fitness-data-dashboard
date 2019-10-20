package com.microsoft.datadashboard.model.dvo;

/**
 * Data Value Object (DVO).
 * Fitness tracking.
 *
 * @author BorisMirage
 * Time: 2019/10/20 15:29
 * Created with IntelliJ IDEA
 */

public class DataDVO {
    private Long id;
    private Long clientId;          // client, device id
    private Double temperature;
//    private Double bloodPressure;
    private Integer heartBeat;
    private Integer stepCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(Integer heartBeat) {
        this.heartBeat = heartBeat;
    }

    public Integer getStepCount() {
        return stepCount;
    }

    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }
}
