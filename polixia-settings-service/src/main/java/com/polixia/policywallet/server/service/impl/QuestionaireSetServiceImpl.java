package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.*;
import com.polixia.policywallet.server.repository.QuestionaireSetRepository;
import com.polixia.policywallet.server.service.ComplianceRuleService;
import com.polixia.policywallet.server.service.FieldDefService;
import com.polixia.policywallet.server.service.QuestionaireCardsService;
import com.polixia.policywallet.server.service.QuestionaireSetService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * QuestionaireSet Service Implementation
 */
@Service
public class QuestionaireSetServiceImpl implements QuestionaireSetService {
    @Autowired
    QuestionaireCardsService questionaireCardsService;

    @Autowired
    ComplianceRuleService complianceRuleService;

    @Autowired
    FieldDefService fieldDefService;

    @Autowired
    QuestionaireSetRepository questionaireSetRepository;

    @Override
    public QuestionaireSet getCQuestionaireSetById(Integer id) {
        return questionaireSetRepository.getCQuestionaireSetById(id);
    }

    @Override
    public QuestionaireSet upsertQuestionaireSet(QuestionaireSet payload) {
        if (payload.getQuestionaireCard().getId() == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        QuestionaireCard cQuestionaireCards = questionaireCardsService.getCardById(payload.getQuestionaireCard().getId());
        if (cQuestionaireCards != null) {
            //if the parent exists those values are set
            payload.setQuestionaireCard(cQuestionaireCards);
            payload.setVersion(cQuestionaireCards.getVersion());
            payload.setCardName(cQuestionaireCards.getCardName());
            payload.setQuestionaireOwner(cQuestionaireCards.getQuestionaireOwner());
            payload.setQuestionaireType(cQuestionaireCards.getQuestionaire());

        } else {
            //null is returned when the parent does not exists
            throw new PolixiaException(ApplicationConstant.ERROR_QCARD_DATA_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_QCARD_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        if (payload.getFieldDef() != null) {
            //checks whether the payload requests nickname
            if (payload.getFieldDef().getId() == null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
            }
            FieldDef cFieldDef = fieldDefService.getCFieldDefById(payload.getFieldDef().getId());
            if (cFieldDef == null) {
                //if the cfield def id does not exists
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_FIELDDEF_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_FIELDDEF_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
            } else {
                //if the nickname is found the values will be modelled
                payload.setFieldDef(cFieldDef);
                payload.setSetNickNameField(cFieldDef.getFieldName());
            }
        }
        if (payload.getcComplianceRules() != null) {
            //check whether the payload needs compliance rules
            if (payload.getcComplianceRules().getId() == null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
            }
            ComplianceRule cComplianceRules = complianceRuleService.getComplianceRuleById(payload.getcComplianceRules().getId());
            if (cComplianceRules != null) {
                // if the compliance rule exist, modells it
                payload.setComplianceRule(cComplianceRules.getComplainceRule());
                payload.setcComplianceRules(cComplianceRules);
            }
            //if the compliance rule does not exist returns null
            else throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_COMPLIANCERULE_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_COMPLIANCERULE_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);

        }
        payload.getQuestionaireCard().getQuestionaireType().setTimestamp(LocalDateTime.now());
        return questionaireSetRepository.save(payload);
    }
}
