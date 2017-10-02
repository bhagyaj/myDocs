package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.QuestionaireData;
import com.polixia.policywallet.server.model.QuestionaireType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
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
    @Query("SELECT qt FROM QuestionaireType qt where qt.storeServer.cSettings.id=:version")
    List<QuestionaireType> getQuestionaireByVersion(@Param("version") Integer Version);

    List<QuestionaireType> findAll();

    @Query("SELECT qt FROM QuestionaireType qt where qt.storeServer.id=:storeserver")
    List<QuestionaireType> findByStoreserverId(@Param("storeserver") int storeserverId);

    @Query("SELECT qt FROM QuestionaireType qt where qt.storeServer.id=:storeserver AND qt.questionaireType=:questionaire" )
    List<QuestionaireType> findByQuestionaireAndOwner(@Param("storeserver") Integer storeserverId, @Param("questionaire") String questionaire);

    @Query("SELECT qt FROM QuestionaireType qt where qt.timestamp >=:dateTime")
    List<QuestionaireType> findByTimestamp(@Param("dateTime") Long dateTime);
}
