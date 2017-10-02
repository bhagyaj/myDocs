package com.polixia.policywallet.server.service;

import java.util.List;

/**
 * Repository class for FieldDef
 */
public interface EventSubscriptionService {

    List<Object> getCEventSubscriptionByVersionId(Integer id);
}
