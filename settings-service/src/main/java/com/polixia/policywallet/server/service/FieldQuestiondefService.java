package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.FieldQuestionDef;

import java.util.List;

/**
 * Created by Jeyanthasingam on 9/12/2017.
 */
public interface FieldQuestiondefService {
    List<Object> getFieldQuestionDefByVersion(Integer version);
}
