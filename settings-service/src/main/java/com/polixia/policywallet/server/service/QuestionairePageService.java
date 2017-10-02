package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionairePage;
import org.springframework.stereotype.Service;

/**
 * QuestionairePage Service
 */
@Service
public interface QuestionairePageService {

    public QuestionairePage getCQuestionairePageById(Integer id);

    QuestionairePage upsertQuestionairePage(QuestionairePage payload);

}
