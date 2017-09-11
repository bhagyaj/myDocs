package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cquestionairepagefields")
public class QuestionairePageField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataView.Specific.class)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "QuestionaireOwner")
    @JsonView(DataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "QuestionaireType")
    @JsonView(DataView.Basic.class)
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(DataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(DataView.Basic.class)
    private String setName;
    @Column(name = "SectionName")
    @JsonView(DataView.Basic.class)
    private String sectionName;
    @ManyToOne
    @JoinColumn(name = "PageId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionairePage questionairePage;
    @Column(name = "PageName")
    @JsonView(DataView.Basic.class)
    private String pageName;
    @ManyToOne
    @JoinColumn(name = "FieldDefId")
    @JsonView(DataView.ServiceSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private FieldDef fieldDef;
    @Column(name = "FieldName")
    @JsonView(DataView.Specific.class)
    private String fieldName;
    @Column(name = "orderNumber")
    @JsonView(DataView.Basic.class)
    private Integer orderNumber;
    @Column(name = "UserInput")
    @JsonView(DataView.Basic.class)
    private boolean userInput;
    @Column(name = "ServerInput")
    @JsonView(DataView.Basic.class)
    private boolean serverInput;
    @Column(name = "MandatoryField")
    @JsonView(DataView.Basic.class)
    private boolean mandatoryField;
    @Column(name = "hiddenField")
    @JsonView(DataView.Basic.class)
    private boolean hiddenField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public QuestionairePage getQuestionairePage() {
        return questionairePage;
    }

    public void setQuestionairePage(QuestionairePage questionairePage) {
        this.questionairePage = questionairePage;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public FieldDef getFieldDef() {
        return fieldDef;
    }

    public void setFieldDef(FieldDef fieldDef) {
        this.fieldDef = fieldDef;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getOrder() {
        return orderNumber;
    }

    public void setOrder(Integer order) {
        this.orderNumber = order;
    }

    public boolean getUserInput() {
        return userInput;
    }

    public void setUserInput(boolean userInput) {
        this.userInput = userInput;
    }

    public boolean getServerInput() {
        return serverInput;
    }

    public void setServerInput(boolean serverInput) {
        this.serverInput = serverInput;
    }

    public boolean getMandatoryField() {
        return mandatoryField;
    }

    public void setMandatoryField(boolean mandatoryField) {
        this.mandatoryField = mandatoryField;
    }

    public boolean getHiddenField() {
        return hiddenField;
    }

    public void setHiddenField(boolean hiddenField) {
        this.hiddenField = hiddenField;
    }
}
