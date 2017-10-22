package com.polixia.policywallet.server.applicationservice.repository;

import com.polixia.policywallet.server.applicationservice.model.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by brupasinghe on 10/16/2017.
 */
public interface ApplicationRepository extends Repository<Application, String> {
    Page<Application> findByApplicationIdStartingWithOrderByCreatedDesc(String search, Pageable pageable);

    Application save(Application application);

    Application getApplicationByApplicationId(String applicationId);
}
