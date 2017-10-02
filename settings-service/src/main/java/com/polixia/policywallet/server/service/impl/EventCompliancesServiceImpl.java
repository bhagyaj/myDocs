package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.EventCompliance;
import com.polixia.policywallet.server.repository.EventCompliancesRepository;
import com.polixia.policywallet.server.service.EventCompliancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventCompliancesServiceImpl implements EventCompliancesService {

    @Autowired
    EventCompliancesRepository eventCompliancesRepository;

    @Override
    public List<EventCompliance> getEventComplianceByVersion(Integer version) {
        return eventCompliancesRepository.getEventComplianceByVersion(version);
    }
}
