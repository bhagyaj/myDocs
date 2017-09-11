package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionaireSet;

/**
 * QuestionaireSet Service
 */
public interface QuestionaireSetService {
    QuestionaireSet getCQuestionaireSetById(Integer id);

    QuestionaireSet upsertQuestionaireSet(QuestionaireSet payload);
}
