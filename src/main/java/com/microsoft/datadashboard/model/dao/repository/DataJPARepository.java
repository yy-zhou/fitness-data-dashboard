package com.microsoft.datadashboard.model.dao.repository;

import com.microsoft.datadashboard.model.dvo.DataDVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author BorisMirage
 * Time: 2019/10/27 11:46
 * Created with IntelliJ IDEA
 */
@Repository     // Spring provided DAO
public interface DataJPARepository extends JpaRepository<DataDVO, Long> {       // extend the framework
    List<DataDVO> findByClientId(Long clientID);        // all data DOV by specific client id

}
