package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.CarrierToVersion;
import com.polixia.policywallet.server.repository.CarrierToVersionRepository;
import com.polixia.policywallet.server.service.CarrierToVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CarrierToVersion Service Implementation
 */
@Service
public class CarrierToVersionServiceImpl implements CarrierToVersionService {
    @Autowired
    CarrierToVersionRepository carrierToVersionRepository;
    @Override
    public CarrierToVersion getStoreServerById(int storeServerId) {
        return carrierToVersionRepository.getCarrierToVersionById(storeServerId);
    }

    @Override
    public List<CarrierToVersion> getStoreserverVersions(String storeserverName) {
        List<CarrierToVersion> carrierToVersions = carrierToVersionRepository.getCarrierToVersionByName(storeserverName);
        if (!carrierToVersions.isEmpty()) {
            for (CarrierToVersion carrierToVersion : carrierToVersions) {
                carrierToVersion.setVersionId(carrierToVersion.getcSettings().getId());
            }
        }
        return carrierToVersions;
    }
}
