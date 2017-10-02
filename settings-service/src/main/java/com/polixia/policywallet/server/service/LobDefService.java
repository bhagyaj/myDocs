package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.Lobdef;

import java.util.List;

/**
 * FieldDef Service
 */
public interface LobDefService {

    List<Object> getCLobdefByVersionId(Integer version);
    Lobdef get(int id);
    Lobdef upsertLobDefinition(Lobdef lobdef);
    List<Lobdef> getall();
}
