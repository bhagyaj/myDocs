package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionaireCard;
import org.springframework.data.repository.Repository;

/**
 * Cards Repository
 */
public interface QuestionaireCardsRepository extends Repository<QuestionaireCard, Integer> {
    QuestionaireCard getCQuestionaireCardsById(Integer id);

    QuestionaireCard save(QuestionaireCard cQuestionaireCards);
}
