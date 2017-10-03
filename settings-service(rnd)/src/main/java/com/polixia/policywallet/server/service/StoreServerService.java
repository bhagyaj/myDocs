package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.StoreServer;

import java.util.List;

/**
 * StoreServer Service
 */
public interface StoreServerService {
    StoreServer getStoreServerById(int storeServerId);
    List<StoreServer> getStoreserverVersions(String storeserver);
}
