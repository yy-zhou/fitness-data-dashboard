package com.test.datadashboard.model.dvo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;

/**
 * Data Value Object (DVO) with Java Persistence API (JPA).
 * Convert Java class to MySQL table.
 * Fitness tracking.
 *
 * @author BorisMirage
 * Time: 2019/10/20 15:29
 * Created with IntelliJ IDEA
 */

@Entity
@Table(name = "data")
// ignore front end pass data for security
@JsonIgnoreProperties(value = {"id", "createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)      //
public class DataDVO implements Serializable {      // serialize class to database-readable file

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;

    @NotNull
    private Long clientId;      // client should not be null

    @NotNull
    @Min(20)
    @Max(100)
    private Double temperature;     // temperature should not be null, and it will have limit

    @NotNull
    @PositiveOrZero
    private Integer stepCount;      // step count should be non-negative int value

    @Column(nullable = false, updatable = false)        //
    @Temporal(TemporalType.TIMESTAMP)                   // time stamp
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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

    public Integer getStepCount() {
        return stepCount;
    }

    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
