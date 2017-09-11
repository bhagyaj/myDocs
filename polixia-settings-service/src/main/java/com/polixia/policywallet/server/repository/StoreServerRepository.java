package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.StoreServer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Repository for StoreServer
 */
@CrossOrigin
public interface StoreServerRepository extends Repository<StoreServer, Integer> {
    StoreServer getSStoreServerById(Integer id);

    @Query("SELECT ss from StoreServer ss WHERE ss.storeServer = :storeServer")
    List<StoreServer> getStoreServerByName(@Param("storeServer") String storeServer);
}
