package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.QuestionaireCard;
import com.polixia.policywallet.server.model.QuestionaireType;
import com.polixia.policywallet.server.repository.QuestionaireCardsRepository;
import com.polixia.policywallet.server.service.QuestionaireCardsService;
import com.polixia.policywallet.server.service.QuestionaireTypeService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * QuestionaireCard Service Implementation
 */
@Service
public class QuestionaireCardsServiceImpl implements QuestionaireCardsService {
    @Autowired
    QuestionaireCardsRepository questionaireCardsRepository;
    @Autowired
    QuestionaireTypeService questionaireTypeService;


    /**
     * Create a card under a questionaire
     *
     * @param payload the request payload
     * @return newly created QuestionaireCard object
     * @throws PolixiaException
     */
    @Override
    public QuestionaireCard upsertCards(QuestionaireCard payload) {
        //        Get foreign key instances
        if (payload.getQuestionaireType().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        QuestionaireType questionaireType = questionaireTypeService.getQuestionaireTypeById(payload.getQuestionaireType().getId());
//           check foreign key instances questionaireType and assign to the card object
        if (questionaireType != null) {
            payload.setQuestionaireType(questionaireType);
            payload.setVersion(questionaireType.getVersion());
            payload.setQuestionaireOwner(questionaireType.getQuestionaireOwner());
            payload.setQuestionaire(questionaireType.getQuestionaireType());
            questionaireType.setTimestamp(LocalDateTime.now().atZone(ZoneOffset.UTC).toEpochSecond());
            return questionaireCardsRepository.save(payload);
        } else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.ERROR_CODE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
    }

    /**
     * Get card By Id
     *
     * @param cardId the QuestionaireCard table primary key
     * @return QuestionaireCard object containing card data
     */
    @Override
    public QuestionaireCard getCardById(int cardId) {
        return questionaireCardsRepository.getCQuestionaireCardsById(cardId);
    }


}
