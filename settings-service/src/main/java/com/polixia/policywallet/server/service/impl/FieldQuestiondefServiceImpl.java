package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.FieldQuestionDef;
import com.polixia.policywallet.server.repository.FieldQuestionDefRepository;
import com.polixia.policywallet.server.service.FieldQuestiondefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jeyanthasingam on 9/12/2017.
 */
@Service
public class FieldQuestiondefServiceImpl implements FieldQuestiondefService {

    @Autowired
    FieldQuestionDefRepository fieldQuestionDefRepository;
    @Override
    public List<Object> getFieldQuestionDefByVersion(Integer version) {
        return fieldQuestionDefRepository.getFieldDefByVersion(version);
    }
}
