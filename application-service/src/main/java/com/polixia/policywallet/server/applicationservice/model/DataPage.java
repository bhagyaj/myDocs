package com.polixia.policywallet.server.applicationservice.model;

import java.util.ArrayList;
import java.util.List;

public class DataPage {

    private String PageName;

    List<DataField> fields = new ArrayList<>();

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    public List<DataField> getFields() {
        return fields;
    }

    public void setFields(List<DataField> fields) {
        this.fields = fields;
    }

    public void addField(EventData eventData){
        DataField dataField = new DataField();
        dataField.setFieldName(eventData.getFieldName());
        dataField.setContent(eventData.getContent());
        dataField.setFieldCode(eventData.getFieldCode());
        fields.add(dataField);

    }
}

