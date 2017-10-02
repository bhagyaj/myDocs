package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.*;
import com.polixia.policywallet.server.repository.QuestionairSectionsRepository;
import com.polixia.policywallet.server.service.ComplianceRuleService;
import com.polixia.policywallet.server.service.FieldDefService;
import com.polixia.policywallet.server.service.QuestionairSectionsService;
import com.polixia.policywallet.server.service.QuestionaireSetService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * QuestionairSections Service Implementation
 */
@Service
public class QuestionairSectionServiceImpl implements QuestionairSectionsService {
    @Autowired
    QuestionaireSetService questionaireSetService;
    @Autowired
    FieldDefService fieldDefService;
    @Autowired
    ComplianceRuleService complianceRuleService;
    @Autowired
    QuestionairSectionsRepository questionairSectionsRepository;

    /**
     * Create a section under questionaire
     *
     * @param payload the request payload
     * @return newly created QuestionaireSection object
     * @throws PolixiaException
     */
    @Override
    public QuestionaireSection upsertSection(QuestionaireSection payload) {
        //        Get foreign key instances
        if(payload.getQuestionaireSet().getId()==null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,ApplicationConstant.HTTP_BAD_REQUEST);
        }
        //           check foreign key instances set and assign to the section object
        QuestionaireSet set = questionaireSetService.getCQuestionaireSetById(payload.getQuestionaireSet().getId());
        if (set != null) {
            payload.setVersion(set.getVersion());
            payload.setQuestionaireOwner(set.getQuestionaireOwner());
            payload.setQuestionaireType(set.getQuestionaireType());
            payload.setCardName(set.getCardName());
            payload.setQuestionaireSet(set);
            payload.setSetName(set.getSetName());

        }else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SETID_NOT_FOUND, ApplicationConstant.ERROR_CODE_SETID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }

//            check whether FieldDefId is correct if exist
        if (payload.getFieldDef() != null) {

            if(payload.getFieldDef().getId()==null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,ApplicationConstant.HTTP_BAD_REQUEST);
            }
            FieldDef fieldDef = fieldDefService.getCFieldDefById(payload.getFieldDef().getId());
            if (fieldDef != null) {
                    payload.setFieldDef(fieldDef);
                    payload.setSectionNickNameField(fieldDef.getFieldName());
            } else {
                    throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_FIELDDEFID_NOT_FOUND, ApplicationConstant.ERROR_CODE_FIELDDEFID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
            }
        }
//            check whether compliance rule is correct if exist
        if (payload.getComplianceRule() != null) {
            if(payload.getComplianceRuleObj().getId()==null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,ApplicationConstant.HTTP_BAD_REQUEST);
            }
            ComplianceRule complianceRules = complianceRuleService.getComplianceRuleById(payload.getComplianceRuleObj().getId());
                if (complianceRules != null) {
                    payload.setComplianceRuleObj(complianceRules);
                    payload.setComplianceRule(complianceRules.getComplainceRule());
                } else {
                    throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_COMPLIANCERULEID_NOT_FOUND, ApplicationConstant.ERROR_CODE_COMPLIANCERULEID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
                }
        }
              payload.getQuestionaireSet().getQuestionaireCard().getQuestionaireType().setTimestamp(LocalDateTime.now().atZone(ZoneOffset.UTC).toEpochSecond());
              return questionairSectionsRepository.save(payload);
    }


    /**
     * Get section data using section Id
     *
     * @param sectionId the priomary key of the QuestionaireSection table
     * @return QuestionaireSection object containing section data
     */
    @Override
    public QuestionaireSection getSectionById(int sectionId) {
        return questionairSectionsRepository.getCQuestionairSectionsById(sectionId);
    }
}
