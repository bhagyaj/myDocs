package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import java.util.List;

public class QuestionaireData {
    @JsonView(QDataView.QDataSummary.class)
    private String tableName;
    @JsonView(QDataView.QDataSummary.class)
    private List<Object> dataList;


//    public void QuestionaireData(String tableName, List<Object> dataList){
//        this.tableName = tableName;
//        this.dataList = dataList;
//    }

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
