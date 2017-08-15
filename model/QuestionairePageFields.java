package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;

@Entity
@Table(name = "cquestionairepagefields")
public class QuestionairePageFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.Basic.class)
    private int id;
    @Column(name = "VersionId")
    @JsonView(QDataView.Basic.class)
    private int versionId;
    @Column(name = "Version")
    @JsonView(QDataView.Basic.class)
    private String version;
    @Column(name = "StoreServerID")
    @JsonView(QDataView.Basic.class)
    private int storeServerID;
    @Column(name = "QuestionaireOwner")
    @JsonView(QDataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "Questionaire_Id")
    @JsonView(QDataView.Basic.class)
    private int questionaire_Id;
    @Column(name = "QuestionaireTypeId")
    @JsonView(QDataView.Basic.class)
    private String questionaireTypeId;
    @Column(name = "Card_Id")
    @JsonView(QDataView.Basic.class)
    private int card_Id;
    @Column(name = "CardId")
    @JsonView(QDataView.Basic.class)
    private String cardId;
    @Column(name = "Set_Id")
    @JsonView(QDataView.Basic.class)
    private int set_Id;
    @Column(name = "SetID")
    @JsonView(QDataView.Basic.class)
    private String setID;
    @Column(name = "Section_Id")
    @JsonView(QDataView.Basic.class)
    private int section_Id;
    @Column(name = "SecID")
    @JsonView(QDataView.Basic.class)
    private String secID;
    @Column(name = "Page_Id")
    @JsonView(QDataView.QDataSummary.class)
    private int cQuestionairePage;
    @Column(name = "PageID")
    @JsonView(QDataView.Basic.class)
    private String pageID;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.Basic.class)
    private int fieldDefId;
    @Column(name = "FieldName")
    @JsonView(QDataView.Basic.class)
    private String fieldName;
    @Column(name = "Order_Number")
    @JsonView(QDataView.Basic.class)
    private String Order_Number;
    @Column(name = "UserInput")
    @JsonView(QDataView.Basic.class)
    private int userInput;
    @Column(name = "ServerInput")
    @JsonView(QDataView.Basic.class)
    private int serverInput;
    @Column(name = "MandatoryField")
    @JsonView(QDataView.Basic.class)
    private int mandatoryField;
    @Column(name = "HiddenField")
    @JsonView(QDataView.Basic.class)
    private int HiddenField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStoreServerID() {
        return storeServerID;
    }

    public void setStoreServerID(int storeServerID) {
        this.storeServerID = storeServerID;
    }

    public String getQuestionaireOwner() {
        return questionaireOwner;
    }

    public void setQuestionaireOwner(String questionaireOwner) {
        this.questionaireOwner = questionaireOwner;
    }

    public int getQuestionaire_Id() {
        return questionaire_Id;
    }

    public void setQuestionaire_Id(int questionaire_Id) {
        this.questionaire_Id = questionaire_Id;
    }

    public String getQuestionaireTypeId() {
        return questionaireTypeId;
    }

    public void setQuestionaireTypeId(String questionaireTypeId) {
        this.questionaireTypeId = questionaireTypeId;
    }

    public int getCard_Id() {
        return card_Id;
    }

    public void setCard_Id(int card_Id) {
        this.card_Id = card_Id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getSet_Id() {
        return set_Id;
    }

    public void setSet_Id(int set_Id) {
        this.set_Id = set_Id;
    }

    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
    }

    public int getSection_Id() {
        return section_Id;
    }

    public void setSection_Id(int section_Id) {
        this.section_Id = section_Id;
    }

    public String getSecID() {
        return secID;
    }

    public void setSecID(String secID) {
        this.secID = secID;
    }

    public int getcQuestionairePage() {
        return cQuestionairePage;
    }

    public void setcQuestionairePage(int cQuestionairePage) {
        this.cQuestionairePage = cQuestionairePage;
    }

    public String getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(String order_Number) {
        Order_Number = order_Number;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
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
        return Order_Number;
    }

    public void setOrder(String order) {
        this.Order_Number = order;
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
        return HiddenField;
    }

    public void setHiddenField(int hiddenField) {
        HiddenField = hiddenField;
    }
}

