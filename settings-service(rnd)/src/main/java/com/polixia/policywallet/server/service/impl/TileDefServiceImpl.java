package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.EventTypeDef;
import com.polixia.policywallet.server.model.QuestionaireType;
import com.polixia.policywallet.server.model.Setting;
import com.polixia.policywallet.server.model.TileDef;
import com.polixia.policywallet.server.repository.TileDefRepository;
import com.polixia.policywallet.server.service.SettingsService;
import com.polixia.policywallet.server.service.TileDefService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Service
public class TileDefServiceImpl implements TileDefService {

    @Autowired
    TileDefRepository tileDefRepository;
    @Autowired
    SettingsService settingsService;

    @Override
    public List<Object> getCTileDefByVersionId(Integer version) {
        return tileDefRepository.getCTileDefVersionId(version);
    }

    @Override
    public TileDef upsertTileDefinition(TileDef payload) {
//        Get foreign key instances
        if(payload.getSetting().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        Setting setting = settingsService.getSettingsById(payload.getSetting().getId());
        if (setting != null) {
            payload.setSetting(setting);
            payload.setVersion(setting.getVersion());
            return tileDefRepository.save(payload);
        } else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.ERROR_CODE_QUESTIONAIRETYPE_ID_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
    }

    @Override
    public List<TileDef> getTileDefinitions() {
        List<TileDef> tileDefs = tileDefRepository.findAll();
        for (TileDef tileDef:tileDefs
             ) {
            tileDef.setVersionId(tileDef.getSetting().getId());
        }
        return tileDefs;
    }

    @Override
    public TileDef getTileDefinitionById(Integer id) {
        TileDef tileDef = tileDefRepository.getTileDefinitionById(id);
        tileDef.setVersionId(tileDef.getSetting().getId());
        return tileDef;
    }
}
