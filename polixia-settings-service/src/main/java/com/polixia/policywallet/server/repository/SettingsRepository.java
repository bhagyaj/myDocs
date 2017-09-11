package com.polixia.policywallet.server.repository;

import com.polixia.policywallet.server.model.Setting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repository for Csettings
 */
public interface SettingsRepository extends Repository<Setting, Integer> {

    /**
     * This method will return the latest versions above the given version
     *
     * @param version
     * @return List<Setting>
     */
    @Query("SELECT s FROM Setting s where s.id>:version")
    List<Object> getSettingsByVersion(@Param("version") Integer version);

    /**
     * This method will return the latest versions above the given version
     *
     * @param version
     * @return List<Setting>
     */
    @Query("SELECT s FROM Setting s where s.id>:version")
    List<Setting> getSettingsListByVersion(@Param("version") Integer version);

    Setting getSettingById(Integer id);

    List<Setting> findAll();
}
