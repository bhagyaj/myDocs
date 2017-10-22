package com.polixia.policywallet.server.applicationservice.service.impl;

import com.netflix.hystrix.HystrixCommand;
import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.core.hystrix.CommonHystrixCommand;
import com.polixia.policywallet.server.applicationservice.exceptions.ServiceException;
import com.polixia.policywallet.server.applicationservice.model.Event;
import com.polixia.policywallet.server.applicationservice.service.EventService;
import com.polixia.policywallet.server.applicationservice.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    HystrixCommand.Setter config;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Event getEventByApplicationIdAndEventType(String applicationId, String eventType, String authorization)  throws InterruptedException, ExecutionException {
        CommonHystrixCommand<Event> requestPolicyCommonHystrix = new CommonHystrixCommand<Event>(
                config, () -> {
            Event event = new Event();
            String url = "http://www.mocky.io/v2/59e5e6da1100000c019192a5";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add(ApplicationConstants.HEADER_AUTHORIZATION, authorization);
            HttpEntity<Event> entity = new HttpEntity<Event>(event, headers);
            ResponseEntity<Event> carrierPolicyResponse = restTemplate.exchange(url, HttpMethod.GET, entity, Event.class);
            if(carrierPolicyResponse.getStatusCodeValue()==200){
                return carrierPolicyResponse.getBody();
            }else{
                throw new ServiceException(ApplicationConstants.ERROR_MESSAGE_EVENT_SERVICE_NOT_RESPONDING,ApplicationConstants.ERROR_CODE_EVENT_SERVICE_NOT_RESPONDING,ApplicationConstants.HTTP_STATUS_INTERNAL_SERVER_ERROR);
            }

        }, () -> {
            return null;
        });
        Future<Event> requestEventFuture =  requestPolicyCommonHystrix.queue();

        Event requestEvent = requestEventFuture.get();

        return requestEvent;
    }
}
