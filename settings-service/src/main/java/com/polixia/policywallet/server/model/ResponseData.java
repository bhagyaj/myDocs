package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;

import java.util.List;

public class ResponseData {
    @JsonView(DataView.DataSummary.class)
    private String tableName;
    @JsonView(DataView.DataSummary.class)
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
