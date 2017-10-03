package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionairePageFldCompliance;

import java.util.List;

public interface QuestionairePageFldCompliancesService {
    List<QuestionairePageFldCompliance> getPageFldComplianceByVersion(Integer version);
}
