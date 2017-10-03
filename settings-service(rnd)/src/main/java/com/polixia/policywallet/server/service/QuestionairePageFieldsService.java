package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionairePageField;

/**
 * QuestionairePageFields Service
 */

public interface QuestionairePageFieldsService {
    QuestionairePageField getCQuestionairePageFieldsById(Integer id);

    QuestionairePageField upsertQuestionairePageField(QuestionairePageField payload);
}
