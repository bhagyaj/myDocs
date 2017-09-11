package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.Lobdef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface LobDefRepository extends Repository<Lobdef, Integer> {

    @Query("SELECT ld FROM Lobdef ld WHERE ld.cSettings.id > :version")
    List<Object> getCLobDefByVersionId(@Param("version") Integer version);

    Lobdef getLobDefById(Integer id);

    Lobdef save(Lobdef lobdef);

    List<Lobdef> findAll();
}
