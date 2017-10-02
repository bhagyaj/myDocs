package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionairePageField;
import org.springframework.data.repository.Repository;

/**
 * Repository class for QuestionairePageField
 */

public interface QuestionairePageFieldsRepository extends Repository<QuestionairePageField, Integer> {
    QuestionairePageField getCQuestionairePageFieldsById(Integer id);

    QuestionairePageField save(QuestionairePageField cQuestionairPageFields);
}
