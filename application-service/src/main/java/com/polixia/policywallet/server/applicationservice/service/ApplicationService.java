package com.polixia.policywallet.server.applicationservice.service;

import com.polixia.policywallet.server.applicationservice.model.Application;
import com.polixia.policywallet.server.applicationservice.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.concurrent.ExecutionException;

public interface ApplicationService {
    Page<Application> findAll(String search, Pageable pageable);

    Application createApplication(Application application);

    Application getApplicationByApplicationId(String applicationId);

    Event getEventByApplicationIdAndEventType(String applicationId, String eventType, String authorization) throws ExecutionException, InterruptedException;
}
