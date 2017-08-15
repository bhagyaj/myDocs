package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;

@Entity
@Table(name = "cquestionairepagefields")
public class CQuestionairePageFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.Basic.class)
    @Column(name = "Id")
    private int id;
    @Column(name = "Version")
    @JsonView(QDataView.Basic.class)
    private String version;
    @Column(name = "QuestionaireOwner")
    @JsonView(QDataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "QuestionaireType")
    @JsonView(QDataView.Basic.class)
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(QDataView.Basic.class)
    private String setName;
    @Column(name = "SectionName")
    @JsonView(QDataView.Basic.class)
    private String sectionName;
    @ManyToOne
    @JoinColumn(name = "PageId")
    @JsonView(QDataView.QDataSummary.class)
    private CQuestionairePage pageId;
    @Column(name = "PageName")
    @JsonView(QDataView.Basic.class)
    private String pageName;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.Basic.class)
    private int fieldDefId;
    @Column(name = "FieldName")
    @JsonView(QDataView.Basic.class)
    private String fieldName;
    @Column(name = "orderNumber")
    @JsonView(QDataView.Basic.class)
    private String orderNumber;
    @Column(name = "UserInput")
    @JsonView(QDataView.Basic.class)
    private int userInput;
    @Column(name = "ServerInput")
    @JsonView(QDataView.Basic.class)
    private int serverInput;
    @Column(name = "MandatoryField")
    @JsonView(QDataView.Basic.class)
    private int mandatoryField;
    @Column(name = "hiddenField")
    @JsonView(QDataView.Basic.class)
    private int hiddenField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getQuestionaireOwner() {
        return questionaireOwner;
    }

    public void setQuestionaireOwner(String questionaireOwner) {
        this.questionaireOwner = questionaireOwner;
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public CQuestionairePage getPageId() {
        return pageId;
    }

    public void setPageId(CQuestionairePage pageId) {
        this.pageId = pageId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getFieldDefId() {
        return fieldDefId;
    }

    public void setFieldDefId(int fieldDefId) {
        this.fieldDefId = fieldDefId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOrder() {
        return orderNumber;
    }

    public void setOrder(String order) {
        this.orderNumber = order;
    }

    public int getUserInput() {
        return userInput;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public int getServerInput() {
        return serverInput;
    }

    public void setServerInput(int serverInput) {
        this.serverInput = serverInput;
    }

    public int getMandatoryField() {
        return mandatoryField;
    }

    public void setMandatoryField(int mandatoryField) {
        this.mandatoryField = mandatoryField;
    }

    public int getHiddenField() {
        return hiddenField;
    }

    public void setHiddenField(int hiddenField) {
        this.hiddenField = hiddenField;
    }
}
