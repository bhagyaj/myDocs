package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionaireSet;
import org.springframework.data.repository.Repository;

/**
 * Repository class for QuestionaireSet
 */
public interface QuestionaireSetRepository extends Repository<QuestionaireSet, Integer> {
    QuestionaireSet getCQuestionaireSetById(Integer id);

    QuestionaireSet save(QuestionaireSet cQuestionaireSet);
}
