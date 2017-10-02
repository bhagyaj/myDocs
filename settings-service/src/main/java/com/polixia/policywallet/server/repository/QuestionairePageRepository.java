package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionairePage;
import org.springframework.data.repository.Repository;

/**
 * Repository class for QuestionairePage
 */
public interface QuestionairePageRepository extends Repository<QuestionairePage, Integer> {

    QuestionairePage getCQuestionairePageById(Integer id);

    QuestionairePage save(QuestionairePage cQuestionairePage);
}
