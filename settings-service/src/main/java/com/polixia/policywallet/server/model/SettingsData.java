package com.polixia.policywallet.server.model;

import java.util.List;

public class SettingsData {

    private String tableName;
    private List<Setting> cSettings;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Setting> getcSettings() {
        return cSettings;
    }

    public void setcSettings(List<Setting> cSettings) {
        this.cSettings = cSettings;
    }
}
