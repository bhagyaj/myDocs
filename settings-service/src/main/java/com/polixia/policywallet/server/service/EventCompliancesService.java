package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.EventCompliance;

import java.util.List;

public interface EventCompliancesService {
    List<EventCompliance> getEventComplianceByVersion(Integer version);
}
