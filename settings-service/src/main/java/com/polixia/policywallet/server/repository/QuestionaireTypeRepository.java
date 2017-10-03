package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionaireType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repository for QuestionaireType
 */
public interface QuestionaireTypeRepository extends Repository<QuestionaireType, Integer> {
    QuestionaireType getCQuestionaireTypeById(Integer id);

    QuestionaireType save(QuestionaireType questionaireType);

    /**
     * This method will fetch the questionaires based on the version
     *
     * @param Version
     * @return
     */
    @Query("SELECT qt FROM QuestionaireType qt where qt.carrierToVersion.cSettings.id=:version")
    List<QuestionaireType> getQuestionaireByVersion(@Param("version") Integer Version);

    List<QuestionaireType> findAll();

    @Query("SELECT qt FROM QuestionaireType qt where qt.carrierToVersion.id=:storeserver")
    List<QuestionaireType> findByStoreserverId(@Param("storeserver") int storeserverId);

    @Query("SELECT qt FROM QuestionaireType qt where qt.carrierToVersion.id=:carrierToVersionId AND qt.questionaireType=:questionaire" )
    List<QuestionaireType> findByQuestionaireAndOwner(@Param("carrierToVersion") Integer carrierToVersionId, @Param("questionaire") String questionaire);
}
