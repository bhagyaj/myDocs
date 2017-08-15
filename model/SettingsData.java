package com.polixia.policywallet.server.model;

import java.util.List;

public class SettingsData {

    private String tableName;
    private List<CSettings> cSettings;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<CSettings> getcSettings() {
        return cSettings;
    }

    public void setcSettings(List<CSettings> cSettings) {
        this.cSettings = cSettings;
    }
}
