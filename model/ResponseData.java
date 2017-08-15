package com.polixia.policywallet.server.model;

import java.util.List;

public class ResponseData {
    private String tableName;
    private List<Object> dataList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }


}
