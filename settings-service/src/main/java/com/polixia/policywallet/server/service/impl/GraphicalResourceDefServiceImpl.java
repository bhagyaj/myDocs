package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.repository.GraphicalResourceDefRepository;
import com.polixia.policywallet.server.service.GraphicalResourceDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/28/2017.
 */
@Service
public class GraphicalResourceDefServiceImpl implements GraphicalResourceDefService {
    @Autowired
    GraphicalResourceDefRepository graphicalResourceDefRepository;

    @Override
    public List<Object> getCGraphicalResourceDefById(Integer id) {
        return graphicalResourceDefRepository.getCGraphicalResourceDefId(id);
    }
}
