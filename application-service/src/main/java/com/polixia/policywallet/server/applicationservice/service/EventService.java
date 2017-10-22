package com.polixia.policywallet.server.applicationservice.service;

import com.polixia.policywallet.server.applicationservice.model.Event;

import java.util.concurrent.ExecutionException;

/**
 * Created by brupasinghe on 10/17/2017.
 */
public interface EventService {
    Event getEventByApplicationIdAndEventType(String applicationId, String eventType, String authorization) throws InterruptedException, ExecutionException;
}
