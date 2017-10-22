package com.polixia.policywallet.server.applicationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

public class EventData {

    private int id;

    private Event event;

    private String applicationId;

    private Integer pageFieldId;

    private String questionaireType;

    private String cardName;

    private String setName;

    private String setNickName;

    private String sectionName;

    private String sectionNickName;

    private String pageName;

    private String fieldName;

    private String content;

    private String fieldCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getPageFieldId() {
        return pageFieldId;
    }

    public void setPageFieldId(Integer pageFieldId) {
        this.pageFieldId = pageFieldId;
    }

    public String getQuestionaireType() {
        return questionaireType;
    }

    public void setQuestionaireType(String questionaireType) {
        this.questionaireType = questionaireType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetNickName() {
        return setNickName;
    }

    public void setSetNickName(String setNickName) {
        this.setNickName = setNickName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionNickName() {
        return sectionNickName;
    }

    public void setSectionNickName(String sectionNickName) {
        this.sectionNickName = sectionNickName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }


}
