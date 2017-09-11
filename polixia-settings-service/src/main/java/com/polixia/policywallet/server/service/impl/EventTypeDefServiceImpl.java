package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.EventTypeDef;
import com.polixia.policywallet.server.model.QuestionaireType;
import com.polixia.policywallet.server.repository.EventTypeDefRepository;
import com.polixia.policywallet.server.service.EventTypeDefService;
import com.polixia.policywallet.server.service.QuestionaireTypeService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Service
public class EventTypeDefServiceImpl implements EventTypeDefService {

    @Autowired
    EventTypeDefRepository eventTypeDefRepository;
    @Autowired
    QuestionaireTypeService questionaireTypeService;

    @Override
    public List<Object> getCEventTypeDefByVersionId(Integer id) {
        return eventTypeDefRepository.getCEventTypeDefByVersionId(id);
    }

    @Override
    public EventTypeDef upsertEventTypeDefinition(EventTypeDef payload) {
//        Get foreign key instances
        if(payload.getQuestionaireType().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        QuestionaireType questionaireType = questionaireTypeService.getQuestionaireTypeById(payload.getQuestionaireType().getId());
        if (questionaireType != null) {
            payload.setQuestionaireType(questionaireType);
            payload.setVersion(questionaireType.getVersion());
            payload.setFieldOwner(questionaireType.getQuestionaireOwner());
            payload.setContentDef(questionaireType.getQuestionaireType());
            return eventTypeDefRepository.save(payload);
        } else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.ERROR_CODE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }

    }

    @Override
    public List<EventTypeDef> getEventTypeDefinitions() {
        List<EventTypeDef> eventTypeDefs = eventTypeDefRepository.findAll();
        if (!eventTypeDefs.isEmpty()){
            for (EventTypeDef eventTypeDef:eventTypeDefs) {
                eventTypeDef.setQuestionaireTypeId(eventTypeDef.getQuestionaireType().getId());
            }
        }
        return eventTypeDefs;
    }

    @Override
    public EventTypeDef getEventTypeDefinitionById(Integer id) {
        EventTypeDef eventTypeDef = eventTypeDefRepository.getEventTypeDefinitionById(id);
        eventTypeDef.setQuestionaireTypeId(eventTypeDef.getQuestionaireType().getId());
        return eventTypeDef;
    }


}
