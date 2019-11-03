package com.test.datadashboard.model.dao;

import com.test.datadashboard.model.dvo.DataDVO;

import java.util.List;

/**
 * Data Access Object (DAO) interface (for decoupling).
 * Provide CRUD operation to data.
 *
 * @author BorisMirage
 * Time: 2019/10/20 15:30
 * Created with IntelliJ IDEA
 */

public interface DataDAO {
    /**
     * Save passing object to database (currently, the database is hash map).
     *
     * @param data input data
     * @return DataDAO
     */
    DataDVO save(DataDVO data);

    /**
     * Find corresponding object by passing id.
     *
     * @param id passing id
     * @return corresponding DVO
     */
    DataDVO findById(Long id);

    List<DataDVO> findAll(String limit);

    List<DataDVO> findByClientId(Long clientId, String field, String sort, String start, String end);
}
