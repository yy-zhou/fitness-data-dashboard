package com.microsoft.datadashboard.model.dao.impl;

import com.microsoft.datadashboard.model.dao.DataDAO;
import com.microsoft.datadashboard.model.dao.repository.DataJPARepository;
import com.microsoft.datadashboard.model.dvo.DataDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author BorisMirage
 * Time: 2019/10/27 11:45
 * Created with IntelliJ IDEA
 */

@Component
public class DataJPADAO implements DataDAO {

    @Autowired
    private DataJPARepository repository;

    @Override
    public DataDVO save(DataDVO data) {
        return repository.save(data);
    }

    /**
     * @param id passing id
     * @return data with corresponding id
     */
    @Override
    public DataDVO findById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.findById(id).get();
        }

        return null;
    }
}
