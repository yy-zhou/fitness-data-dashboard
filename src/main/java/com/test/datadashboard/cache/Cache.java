package com.test.datadashboard.cache;

import com.test.datadashboard.model.dvo.DataDVO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BorisMirage
 * Time: 2019/11/03 11:49 AM
 * Created with IntelliJ IDEA
 */

@Component
public class Cache {
    private Map<Long, DataDVO> map = new HashMap<>();

    public DataDVO put(Long id, DataDVO data) {
        map.put(id, data);

        return data;
    }

    public DataDVO get(Long id) {
        return map.getOrDefault(id, null);
    }
}
