package com.polixia.policywallet.server.applicationservice.service.impl;

import com.polixia.policywallet.server.applicationservice.model.Application;
import com.polixia.policywallet.server.applicationservice.model.Event;
import com.polixia.policywallet.server.applicationservice.repository.ApplicationRepository;
import com.polixia.policywallet.server.applicationservice.service.ApplicationService;
import com.polixia.policywallet.server.applicationservice.service.EventService;
import com.polixia.policywallet.server.applicationservice.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    EventService eventService;


    public Page<Application> findAll(String search,Pageable pageable){
        Page<Application> applications = applicationRepository.findByApplicationIdStartingWithOrderByCreatedDesc(search,pageable);
        return applications;
    }

    @Override
    public Application createApplication(Application application) {
        application.setApplicationId(ApplicationUtil.getUniqueApplicationId());
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationByApplicationId(String applicationId) {
        return applicationRepository.getApplicationByApplicationId(applicationId);
    }

    @Override
    public Event getEventByApplicationIdAndEventType(String applicationId, String eventType, String authorization) throws ExecutionException, InterruptedException {
        return eventService.getEventByApplicationIdAndEventType(applicationId,eventType,authorization);
    }

}
