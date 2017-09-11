package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.QuestionaireType;
import com.polixia.policywallet.server.model.StoreServer;
import com.polixia.policywallet.server.repository.QuestionaireTypeRepository;
import com.polixia.policywallet.server.service.QuestionaireTypeService;
import com.polixia.policywallet.server.service.StoreServerService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * QuestionaireType Service Implementation
 */
@Service
public class QuestionaireTypeServiceImpl implements QuestionaireTypeService {
    @Autowired
    QuestionaireTypeRepository questionaireTypeRepository;
    @Autowired
    StoreServerService storeServerService;

    @Override
    public QuestionaireType upsertQuestionnaire(QuestionaireType payload) {
        //        Get foreign key instances
        if(payload.getStoreServer().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        StoreServer storeServer = storeServerService.getStoreServerById(payload.getStoreServer().getId());
        if (storeServer != null) {
            payload.setStoreServer(storeServer);
            payload.setVersion(storeServer.getVersion());
            payload.setQuestionaireOwner(storeServer.getStoreServer());
            payload.setTimestamp(LocalDateTime.now().getLong());
            return questionaireTypeRepository.save(payload);
        } else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.ERROR_CODE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }

    }

    @Override
    public QuestionaireType getQuestionaireTypeById(int questionaireTypeId) {
        return questionaireTypeRepository.getCQuestionaireTypeById(questionaireTypeId);
    }


    /**
     * This method will return the hierarchical questionaire structure base
     *
     * @param version
     * @return List<QuestionaireData>
     */
    @Override
    public List<QuestionaireType> getQuestionaireTypeByVersion(Integer version) {
        return questionaireTypeRepository.getQuestionaireByVersion(version);
    }

    @Override
    public List<QuestionaireType> findAll() {
        return questionaireTypeRepository.findAll();
    }

    @Override
    public List<QuestionaireType> getQuestionaireByStoreserverId(int storeserverId) {
        return questionaireTypeRepository.findByStoreserverId(storeserverId);
    }

    @Override
    public List<QuestionaireType> getQuestionaireByOwnerAndType(Integer storeserverId, String questionaire) {
        return questionaireTypeRepository.findByQuestionaireAndOwner(storeserverId,questionaire);
    }

    @Override
    public List<QuestionaireType> getHierarchicalQuestionaireSync(Long dateTime) {
        return questionaireTypeRepository.findByTimestamp(dateTime);
    }
}
