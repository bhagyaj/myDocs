package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.StoreServer;
import com.polixia.policywallet.server.repository.StoreServerRepository;
import com.polixia.policywallet.server.service.StoreServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StoreServer Service Implementation
 */
@Service
public class StoreServerServiceImpl implements StoreServerService {
    @Autowired
    StoreServerRepository storeServerRepository;

    @Override
    public StoreServer getStoreServerById(int storeServerId) {
        return storeServerRepository.getSStoreServerById(storeServerId);
    }

    @Override
    public List<StoreServer> getStoreserverVersions(String storeserverName) {
        List<StoreServer> storeServers = storeServerRepository.getStoreServerByName(storeserverName);
        if (!storeServers.isEmpty()) {
            for (StoreServer storeServer : storeServers) {
                storeServer.setVersionId(storeServer.getcSettings().getId());
            }
        }
        return storeServers;
    }
}
