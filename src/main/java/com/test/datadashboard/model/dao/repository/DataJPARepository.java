package com.test.datadashboard.model.dao.repository;

import com.test.datadashboard.model.dvo.DataDVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author BorisMirage
 * Time: 2019/10/27 11:46
 * Created with IntelliJ IDEA
 */
@Repository     // Spring provided DAO
public interface DataJPARepository extends JpaRepository<DataDVO, Long> {       // extend the framework

    // JPA config (customize)
    @Query(value = "SELECT * from data LIMIT :limit", nativeQuery = true)
    List<DataDVO> findAllByLimit(@Param("limit") Integer limit);

    List<DataDVO> findByClientId(Long clientID);        // all data DOV by specific client id

    List<DataDVO> findByClientIdOrderByStepCount(Long clientId);        // auto completed

    List<DataDVO> findByClientIdOrderByStepCountDesc(Long clientId);    // auto completed

    List<DataDVO> findByClientIdAndStepCountIsBetween(Long clientId, Integer start, Integer end);   // auto completed
}
