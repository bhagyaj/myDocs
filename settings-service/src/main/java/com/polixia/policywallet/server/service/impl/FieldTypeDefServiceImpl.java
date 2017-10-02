package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.FieldTypeDef;
import com.polixia.policywallet.server.model.Setting;
import com.polixia.policywallet.server.repository.FieldTypeDefRepository;
import com.polixia.policywallet.server.service.FieldTypeDefService;
import com.polixia.policywallet.server.service.SettingsService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Service
public class FieldTypeDefServiceImpl implements FieldTypeDefService {

    @Autowired
    FieldTypeDefRepository fieldTypeDefRepository;

    @Autowired
    SettingsService settingsService;

    @Override
    public List<Object> getCFieldTypeDefByVersionId(Integer version) {
        return fieldTypeDefRepository.getCFieldTypeDefByVersionId(version);
    }
    /**
     * This will upsertLobDefinition a field Type Definition
     * @param fieldTypeDef
     * @return
     */
    @Override
    public FieldTypeDef upsertFieldTypeDef(FieldTypeDef fieldTypeDef) {
        if(fieldTypeDef.getcSettings().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND,
                    ApplicationConstant.HTTP_BAD_REQUEST);
        }
        Setting setting = settingsService.getSettingById(fieldTypeDef.getcSettings().getId());
        if(setting==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SECTION_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_SECTION_NOT_FOUND,
                    ApplicationConstant.HTTP_BAD_REQUEST);
        }
        fieldTypeDef.setVersion(setting.getVersion());
        fieldTypeDef.setcSettings(setting);
        return fieldTypeDefRepository.save(fieldTypeDef);
    }

    /**
     * this will return all Field Type Definitions
     * @return
     */
    @Override
    public List<FieldTypeDef> getall() {
        List<FieldTypeDef> fieldTypeDefs = fieldTypeDefRepository.findAll();
        for (FieldTypeDef fieldTypeDef: fieldTypeDefs
             ) {
            fieldTypeDef.setVersionId(fieldTypeDef.getcSettings().getId());
        }
        return fieldTypeDefs;
    }

    /**
     * This will fetch field Type based on Id
     * @param id
     * @return
     */
    @Override
    public FieldTypeDef get(Integer id) {
        FieldTypeDef fieldTypeDef = fieldTypeDefRepository.getFieldTypeDefById(id);
        fieldTypeDef.setVersionId(fieldTypeDef.getcSettings().getId());
        return fieldTypeDef;
    }

    @Override
    public List<FieldTypeDef> getFieldTypesByVersion(Integer version) {
        List<FieldTypeDef> fieldTypeDefs = fieldTypeDefRepository.findByVersion(version);
        if (!fieldTypeDefs.isEmpty()){
            for (FieldTypeDef fieldTypeDef:fieldTypeDefs
                 ) {
                fieldTypeDef.setVersionId(fieldTypeDef.getcSettings().getId());
            }
        }
        return fieldTypeDefs;
    }
}
