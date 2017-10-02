package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionaireCard;

/**
 * QuestionaireCards Service
 */
public interface QuestionaireCardsService {
    QuestionaireCard upsertCards(QuestionaireCard payload);

    QuestionaireCard getCardById(int cardId);
}
