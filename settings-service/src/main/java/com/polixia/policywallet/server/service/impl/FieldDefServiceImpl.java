package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.FieldDef;
import com.polixia.policywallet.server.model.FieldTypeDef;
import com.polixia.policywallet.server.model.StoreServer;
import com.polixia.policywallet.server.repository.FieldDefRepository;
import com.polixia.policywallet.server.service.FieldDefService;
import com.polixia.policywallet.server.service.FieldTypeDefService;
import com.polixia.policywallet.server.service.StoreServerService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FieldDef service
 */
@Service
public class FieldDefServiceImpl implements FieldDefService {
    @Autowired
    FieldDefRepository fieldDefRepository;

    @Autowired
    StoreServerService storeServerService;

    @Autowired
    FieldTypeDefService fieldTypeDefService;

    @Override
    public FieldDef getCFieldDefById(Integer id) {
        FieldDef fieldDef = fieldDefRepository.getCFieldDefById(id);
        fieldDef.setStoreServerId(fieldDef.getsStoreServer().getId());
        if (fieldDef.getFieldTypeDef()!=null)
            fieldDef.setFieldTypeDefId(fieldDef.getFieldTypeDef().getId());
        return fieldDef;
    }

    @Override
    public List<Object> getCFieldDefByVersionId(Integer version) {
        return fieldDefRepository.getCFieldDefByVersionId(version);
    }

    @Override
    public List<FieldDef> getFieldDefinitions(Integer storeserver) {
        List<FieldDef> fieldDefs = fieldDefRepository.findByStoreServer(storeserver);
        if (!fieldDefs.isEmpty()){
            for (FieldDef fieldDef : fieldDefs) {
                if (fieldDef.getFieldTypeDef()!=null)
                fieldDef.setFieldTypeDefId(fieldDef.getFieldTypeDef().getId());
                fieldDef.setStoreServerId(fieldDef.getsStoreServer().getId());
            }
        }
        return fieldDefs;
    }

    @Override
    public FieldDef upsertFieldDefinition(FieldDef fieldDef) {

        if (fieldDef.getFieldTypeDef() != null) {
            if (fieldDef.getFieldTypeDef().getId() == null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
            }
            FieldTypeDef fieldTypeDef = fieldTypeDefService.get(fieldDef.getFieldTypeDef().getId());
            if (fieldTypeDef == null) {
                throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_FIELDTYPEDEF_NOT_FOUND,
                        ApplicationConstant.ERROR_CODE_FIELDDEF_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
            } else {
                fieldDef.setFieldType(fieldTypeDef.getFieldType());
            }
        }

        if(fieldDef.getsStoreServer().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }

        StoreServer storeServer = storeServerService.getStoreServerById(fieldDef.getsStoreServer().getId());
        if (storeServer == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_STORESERVER_ID_NOT_FOUND, ApplicationConstant.ERROR_CODE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        } else {
            fieldDef.setsStoreServer(storeServer);
            fieldDef.setVersion(storeServer.getVersion());
            fieldDef.setFieldOwner(storeServer.getStoreServer());
         }
        return fieldDefRepository.save(fieldDef);
    }
}
