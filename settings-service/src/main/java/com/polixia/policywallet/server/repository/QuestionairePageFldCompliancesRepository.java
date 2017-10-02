package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionairePageFldCompliance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Questionaire Page Field Compliance
 */
public interface QuestionairePageFldCompliancesRepository extends Repository<QuestionairePageFldCompliance, Integer> {
    @Query("SELECT qpfc FROM QuestionairePageFldCompliance qpfc WHERE qpfc.questionairePageField.questionairePage.questionaireSection.questionaireSet.questionaireCard.questionaireType.storeServer.cSettings.id=:version")
    List<QuestionairePageFldCompliance> getPageFldComplianceByVersion(@Param("version") Integer version);

}
