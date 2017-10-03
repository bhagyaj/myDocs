package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionaireSection;
import org.springframework.data.repository.Repository;

/**
 * Repository class for QuestionaireSection
 */
public interface QuestionairSectionsRepository extends Repository<QuestionaireSection, Integer> {
    QuestionaireSection getCQuestionairSectionsById(Integer id);

    QuestionaireSection save(QuestionaireSection cQuestionaireSections);
}
