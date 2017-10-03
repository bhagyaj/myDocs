package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.ComplianceRule;
import com.polixia.policywallet.server.model.QuestionaireSection;
import com.polixia.policywallet.server.model.QuestionairePage;
import com.polixia.policywallet.server.repository.QuestionairePageRepository;
import com.polixia.policywallet.server.service.ComplianceRuleService;
import com.polixia.policywallet.server.service.QuestionairSectionsService;
import com.polixia.policywallet.server.service.QuestionairePageService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * QuestionairePage Service Implementation
 */
@Service
public class QuestionairePageServiceImpl implements QuestionairePageService {
    @Autowired
    QuestionairePageRepository questionairePageRepository;
    @Autowired
    QuestionairSectionsService questionaireSectionService;

    @Autowired
    ComplianceRuleService complianceRuleService;

    @Override
    public QuestionairePage getCQuestionairePageById(Integer id) {
        return questionairePageRepository.getCQuestionairePageById(id);
    }

    @Override
    public QuestionairePage upsertQuestionairePage(QuestionairePage payload) {
        if (payload.getQuestionaireSection().getId() == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,
                    ApplicationConstant.HTTP_BAD_REQUEST);

        }
        QuestionaireSection cQuestionaireSections = questionaireSectionService.getSectionById(payload.getQuestionaireSection().getId());
        if (cQuestionaireSections != null) {
            //if the section exits the hierarchy is set to the page
            payload.setVersion(cQuestionaireSections.getVersion());
            payload.setQuestionaireOwner(cQuestionaireSections.getQuestionaireOwner());
            payload.setQuestionaireType(cQuestionaireSections.getQuestionaireType());
            payload.setCardName(cQuestionaireSections.getCardName());
            payload.setSetName(cQuestionaireSections.getSetName());
            payload.setSectionName(cQuestionaireSections.getSectionName());
            payload.setQuestionaireSection(cQuestionaireSections);
        }
        //returns page without section & does not upsertQuestionaireSet page
        else throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SECTION_NOT_FOUND,
                ApplicationConstant.ERROR_CODE_SECTION_NOT_FOUND,
                ApplicationConstant.HTTP_BAD_REQUEST);

        if (payload.getComplianceRule() != null) {
            if (payload.getComplianceRuleObj().getId() == null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,
                        ApplicationConstant.HTTP_BAD_REQUEST);

            }
            ComplianceRule cComplianceRules = complianceRuleService.getComplianceRuleById(payload.getComplianceRuleObj().getId());
            if (cComplianceRules == null) {
                //compliance rule not found exception throws only when wrong compliance rule is given
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_COMPLIANCERULE_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_COMPLIANCERULE_NOT_FOUND,
                        ApplicationConstant.HTTP_SC_NOT_FOUND);
            } else {
                //else the compliance rule is set
                payload.setComplianceRuleObj(cComplianceRules);
                payload.setComplianceRule(cComplianceRules.getComplainceRule());
            }
        }
        payload.getQuestionaireSection().getQuestionaireSet().getQuestionaireCard().getQuestionaireType().setTimestamp(LocalDateTime.now().atZone(ZoneOffset.UTC).toEpochSecond());
        return questionairePageRepository.save(payload);
    }

}
