package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.repository.GraphicalResourceTypeRepository;
import com.polixia.policywallet.server.service.GraphicalResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/28/2017.
 */
@Service
public class GraphicalResourceTypeServiceImpl implements GraphicalResourceTypeService {
    @Autowired
    GraphicalResourceTypeRepository graphicalResourceTypeRepository;

    @Override
    public List<Object> getCGraphicalResourceTypeById(Integer id) {
        return graphicalResourceTypeRepository.getCGraphicalResourceTypeById(id);
    }
}
