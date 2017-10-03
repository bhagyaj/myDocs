package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.CarrierToVersion;

import java.util.List;

/**
 * CarrierToVersion Service
 */
public interface CarrierToVersionService {
    CarrierToVersion getStoreServerById(int storeServerId);
    List<CarrierToVersion> getStoreserverVersions(String storeserver);
}
