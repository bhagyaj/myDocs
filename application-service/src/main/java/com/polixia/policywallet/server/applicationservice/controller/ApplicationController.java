package com.polixia.policywallet.server.applicationservice.controller;


import com.polixia.policywallet.core.component.LoggerFactory;
import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.applicationservice.exceptions.ServiceException;
import com.polixia.policywallet.server.applicationservice.model.Application;
import com.polixia.policywallet.server.applicationservice.model.Event;
import com.polixia.policywallet.server.applicationservice.service.ApplicationService;
import com.polixia.policywallet.server.applicationservice.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/policywallet/server/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Bean
    private  LoggerFactory.Logger logger() {
        return new LoggerFactory.Logger(this.getClass());
    }

    @Autowired
    LoggerFactory.Logger logger;

    /**
     * Get all available applications which satisfy given search criteria
     * @param search the search word
     * @param pageable the size and the page of the object
     * @return page of applications
     */
    @RequestMapping( method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Application> getApplications(@RequestParam("search") String search, Pageable pageable){
        return applicationService.findAll(search,pageable);
    }

    /**
     * Create application
     * @param application application object
     * @return application
     */
    @RequestMapping( method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Application createApplications(@RequestBody Application application){
        return applicationService.createApplication(application);
    }

    /**
     * Get application data by Application Id
     * @param applicationId application Id
     * @return application
     */
    @RequestMapping( value = "/{ApplicationId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Application getApplicationByApplicationId(@PathVariable("ApplicationId") String applicationId){
        return applicationService.getApplicationByApplicationId(applicationId);
    }

    /**
     * Get Event By ApplicationId And EventType
     * @param applicationId application Id
     * @return application
     */
    @RequestMapping( value = "/{ApplicationId}/events", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Event getEventByApplicationIdAndEventType(@PathVariable("ApplicationId") String applicationId, @RequestParam("eventType") String eventType, @RequestHeader("Authorization") String authorization) throws ExecutionException, InterruptedException {
        try {
            return applicationService.getEventByApplicationIdAndEventType(applicationId,eventType ,authorization);
        }
        catch (ServiceException se){
            logger.setMessage(se.getMessage()).setOperationName("Get Event By ApplicationId And EventType");
            throw new PolixiaException(ApplicationConstants.ERROR_MESSAGE_INTERNAL_SERVER_ERROR.concat(se.getErrorMessage()),ApplicationConstants.ERROR_CODE_EVENT_SERVICE_NOT_RESPONDING,ApplicationConstants.HTTP_STATUS_INTERNAL_SERVER_ERROR,se);
        }

    }

}
