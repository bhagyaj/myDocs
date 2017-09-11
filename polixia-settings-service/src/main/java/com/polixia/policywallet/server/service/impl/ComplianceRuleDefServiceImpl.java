package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.ComplianceRuleDef;
import com.polixia.policywallet.server.repository.ComplianceRuleDefRepository;
import com.polixia.policywallet.server.service.ComplianceRuleDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComplianceRuleDefServiceImpl implements ComplianceRuleDefService {


    @Autowired
    ComplianceRuleDefRepository complianceRuleDefRepository;

    @Override
    public List<ComplianceRuleDef> getComplianceRuleDefByVersion(Integer version) {
        return complianceRuleDefRepository.getComplianceRuleDefByVersion(version);
    }
}

