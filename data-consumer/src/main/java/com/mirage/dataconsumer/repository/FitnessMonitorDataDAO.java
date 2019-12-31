package com.mirage.dataconsumer.repository;

import com.mirage.dataconsumer.model.FitnessMonitorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access object for fitness monitor data.
 *
 * @author BorisMirage
 * Time: 2019/12/30 17:05
 * Created with IntelliJ IDEA
 */
@Repository
public interface FitnessMonitorDataDAO extends MongoRepository<FitnessMonitorData, String> {
}
