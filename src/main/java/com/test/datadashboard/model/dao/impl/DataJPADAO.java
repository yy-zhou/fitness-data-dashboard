package com.test.datadashboard.model.dao.impl;

import com.test.datadashboard.model.dao.DataDAO;
import com.test.datadashboard.model.dao.repository.DataJPARepository;
import com.test.datadashboard.model.dvo.DataDVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * @return all data in database
     */
    @Override
    public List<DataDVO> findAll(String limit) {
        if (limit == null) {
            return repository.findAll();
        } else {
            return repository.findAllByLimit(Integer.valueOf(limit));
        }
    }

    @Override
    public List<DataDVO> findByClientId(Long clientId, String field, String sort, String start, String end) {
        if (field != null && field.equals("step_count")) {

            if (sort.equals("desc")) {
                return repository.findByClientIdOrderByStepCountDesc(clientId);

            } else if (start != null && !start.isEmpty() && end != null && !end.isEmpty()) {
                return repository.findByClientIdAndStepCountIsBetween(clientId, Integer.valueOf(start), Integer.valueOf(end));

            } else {
                return repository.findByClientIdOrderByStepCount(clientId);
            }

        } else {
            return repository.findByClientId(clientId);
        }
    }
}
