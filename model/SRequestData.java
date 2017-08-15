package com.polixia.policywallet.server.model;

import java.util.List;

public class SRequestData {
    private String tableName;
    private List<ModelVersion> versions;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ModelVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ModelVersion> versions) {
        this.versions = versions;

    }
}
