package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionaireType;

import java.util.List;

/**
 * QuestionaireType Service
 */
public interface QuestionaireTypeService {

    QuestionaireType upsertQuestionnaire(QuestionaireType payload);

    QuestionaireType getQuestionaireTypeById(int questionaireTypeId);

    List<QuestionaireType> getQuestionaireTypeByVersion(Integer version);

    List<QuestionaireType> findAll();

    List<QuestionaireType> getQuestionaireByStoreserverId(int storeserverId);

    List<QuestionaireType> getQuestionaireByOwnerAndType(Integer storeserverId, String questionaire);

    List<QuestionaireType> getHierarchicalQuestionaireSync(Long dateTime);
}
