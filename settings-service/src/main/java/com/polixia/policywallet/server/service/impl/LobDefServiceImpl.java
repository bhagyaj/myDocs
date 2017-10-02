package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.model.Lobdef;
import com.polixia.policywallet.server.model.Setting;
import com.polixia.policywallet.server.repository.LobDefRepository;
import com.polixia.policywallet.server.service.LobDefService;
import com.polixia.policywallet.server.service.SettingsService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Service
public class LobDefServiceImpl implements LobDefService {

    @Autowired
    LobDefRepository lobDefRepository;

    @Autowired
    SettingsService settingsService;

    @Override
    public List<Object> getCLobdefByVersionId(Integer version) {
        return lobDefRepository.getCLobDefByVersionId(version);
    }

    @Override
    public Lobdef get(int id) {
        Lobdef lobdef = lobDefRepository.getLobDefById(id);
        lobdef.setVersionId(lobdef.getcSettings().getId());
        return lobdef;
    }

    @Override
    public Lobdef upsertLobDefinition(Lobdef lobdef) {
        if(lobdef.getcSettings().getId()==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_IDENTIFIER_NOT_FOUND, ApplicationConstant.ERROR_CODE_IDENTIFIER_NOT_FOUND, ApplicationConstant.HTTP_BAD_REQUEST);
        }
        Setting setting = settingsService.getSettingById(lobdef.getcSettings().getId());
        if(setting==null){
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SETTINGS_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_SETTINGS_NOT_FOUND,ApplicationConstant.HTTP_BAD_REQUEST);

        }
        else{
            lobdef.setVersion(setting.getVersion());
            lobdef.setcSettings(setting);
        }
        return lobDefRepository.save(lobdef);
    }

    @Override
    public List<Lobdef> getall() {
        List<Lobdef> lobdefs = lobDefRepository.findAll();
        for (Lobdef lobdef:lobdefs
             ) {
            lobdef.setVersionId(lobdef.getcSettings().getId());
        }
        return lobdefs;
    }
}
