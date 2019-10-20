package com.microsoft.datadashboard.model.dao;

import com.microsoft.datadashboard.model.dvo.DataDVO;

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
}
