package com.microsoft.datadashboard.model.dao.impl;

import com.microsoft.datadashboard.model.dao.DataDAO;
import com.microsoft.datadashboard.model.dvo.DataDVO;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Implementation of DAO interface (for decoupling).
 *
 * @author BorisMirage
 * Time: 2019/10/20 15:40
 * Created with IntelliJ IDEA
 */

@Repository
public class DataHashMapDAO implements DataDAO {

    private HashMap<Long, DataDVO> m = new HashMap<>();

    /**
     * @param data input data
     * @return DataDAO
     */
    @Override
    public DataDVO save(DataDVO data) {
        Long id = data.getId();
        if (id == null || !m.containsKey(id)) {
            id = m.size() + 1L;
            data.setId(id);
        }

        m.put(id, data);

        return data;
    }

    /**
     * @param id input ID
     * @return DAO found by ID
     */
    @Override
    public DataDVO findById(Long id) {

        return m.get(id);
    }
}
