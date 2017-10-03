package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.CarrierToVersion;
import com.polixia.policywallet.server.model.QuestionaireType;
import com.polixia.policywallet.server.repository.QuestionaireTypeRepository;
import com.polixia.policywallet.server.service.QuestionaireTypeService;
import com.polixia.policywallet.server.service.CarrierToVersionService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * QuestionaireType Service Implementation
 */
@Service
public class QuestionaireTypeServiceImpl implements QuestionaireTypeService {
    @Autowired
    QuestionaireTypeRepository questionaireTypeRepository;
    @Autowired
    CarrierToVersionService carrierToVersionService;

    @Override
    public QuestionaireType upsertQuestionnaire(QuestionaireType payload) {
        //        Get foreign key instances
        if(payload.getCarrierToVersion().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        CarrierToVersion carrierToVersion = carrierToVersionService.getStoreServerById(payload.getCarrierToVersion().getId());
        if (carrierToVersion != null) {
            payload.setCarrierToVersion(carrierToVersion);
            payload.setVersion(carrierToVersion.getVersion());
            payload.setQuestionaireOwner(carrierToVersion.getCarrierCode());
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
}
