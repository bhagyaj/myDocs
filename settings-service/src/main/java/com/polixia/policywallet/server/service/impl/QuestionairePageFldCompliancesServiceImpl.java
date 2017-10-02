package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.QuestionairePageFldCompliance;
import com.polixia.policywallet.server.repository.QuestionairePageFldCompliancesRepository;
import com.polixia.policywallet.server.service.QuestionairePageFldCompliancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionairePageFldCompliancesServiceImpl implements QuestionairePageFldCompliancesService {

    @Autowired
    QuestionairePageFldCompliancesRepository questionairePageFldCompliancesRepository;

    @Override
    public List<QuestionairePageFldCompliance> getPageFldComplianceByVersion(Integer version) {
        return questionairePageFldCompliancesRepository.getPageFldComplianceByVersion(version);
    }
}
