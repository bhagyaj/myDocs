package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.FieldDef;
import com.polixia.policywallet.server.model.QuestionairePage;
import com.polixia.policywallet.server.model.QuestionairePageField;
import com.polixia.policywallet.server.repository.QuestionairePageFieldsRepository;
import com.polixia.policywallet.server.service.FieldDefService;
import com.polixia.policywallet.server.service.QuestionairePageFieldsService;
import com.polixia.policywallet.server.service.QuestionairePageService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * QuestionairePageFields Service Implementation
 */
@Service
public class QuestionairePageFieldsServiceImpl implements QuestionairePageFieldsService {
    @Autowired
    QuestionairePageFieldsRepository questionairePageFieldsRepository;
    @Autowired
    QuestionairePageService questionairePageService;
    @Autowired
    FieldDefService fieldDefService;

    /**
     * Create new page field for a questionaire
     *
     * @param payload the request payload
     * @return newly created QuestionairePageField object
     */
    @Override
    public QuestionairePageField upsertQuestionairePageField(QuestionairePageField payload) {
        //        Get foreign key instances
        if(payload.getQuestionairePage().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        QuestionairePage cQuestionairePage = questionairePageService.getCQuestionairePageById(payload.getQuestionairePage().getId());
//       check foreign key page instances and assign to the pageField object
        if (cQuestionairePage != null) {
            payload.setVersion(cQuestionairePage.getVersion());
            payload.setQuestionaireOwner(cQuestionairePage.getQuestionaireOwner());
            payload.setQuestionaireType(cQuestionairePage.getQuestionaireType());
            payload.setCardName(cQuestionairePage.getCardName());
            payload.setSetName(cQuestionairePage.getSetName());
            payload.setSectionName(cQuestionairePage.getSectionName());
            payload.setQuestionairePage(cQuestionairePage);
            payload.setPageName(cQuestionairePage.getPageName());
        }
        else
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_PAGEID_NOT_FOUND, ApplicationConstant.ERROR_CODE_PAGEID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
//        check whether identifier exists
        if(payload.getFieldDef().getId() == null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
//       check foreign key cFieldDef instances and assign to the pageField object
        FieldDef cFieldDef = fieldDefService.getCFieldDefById(payload.getFieldDef().getId());
        if (cFieldDef != null) {
            payload.setFieldDef(cFieldDef);
            payload.setFieldName(cFieldDef.getFieldName());
        } else
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_FIELDDEFID_NOT_FOUND, ApplicationConstant.ERROR_CODE_FIELDDEFID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        payload.getQuestionairePage().getQuestionaireSection().getQuestionaireSet().getQuestionaireCard().getQuestionaireType().setTimestamp(LocalDateTime.now());
        return questionairePageFieldsRepository.save(payload);
    }


    /**
     * Get page field data using pageFieldId
     *
     * @param pageFieldId the primary key of the QuestionairePageField table
     * @return QuestionairePageField object
     */
    @Override
    public QuestionairePageField getCQuestionairePageFieldsById(Integer pageFieldId) {
        return questionairePageFieldsRepository.getCQuestionairePageFieldsById(pageFieldId);
    }

}
