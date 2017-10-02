package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.repository.EventSubscriptionRepository;
import com.polixia.policywallet.server.service.EventSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Service
public class EventSubscriptionServiceImpl implements EventSubscriptionService {

    @Autowired
    EventSubscriptionRepository eventSubscriptionRepository;

    @Override
    public List<Object> getCEventSubscriptionByVersionId(Integer id) {
        return eventSubscriptionRepository.getCEventSubscriptionByVersionId(id);
    }
}
