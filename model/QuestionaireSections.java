package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cquestionairsections")
public class QuestionaireSections {
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
    @Column(name = "StoreServerId")
    @JsonView(QDataView.Basic.class)
    private int storeServerId;
    @Column(name = "QuestionaireOwner")
    @JsonView(QDataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "QuestionaireType_Id")
    @JsonView(QDataView.Basic.class)
    private int questionaireType_Id;
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
    @JsonView(QDataView.QDataSummary.class)
    private int cQuestionaireSet;
    @Column(name = "SetID")
    @JsonView(QDataView.Basic.class)
    private String setID;
    @Column(name = "SecID")
    @JsonView(QDataView.Basic.class)
    private String secID;
    @Column(name = "SectionLogo")
    @JsonView(QDataView.Basic.class)
    private String sectionLogo;
    @Column(name = "SectionText")
    @JsonView(QDataView.Basic.class)
    private String sectionText;
    @Column(name = "Order_Number")
    @JsonView(QDataView.Basic.class)
    private int Order_Number;
    @Column(name = "SectionSet")
    @JsonView(QDataView.Basic.class)
    private int sectionSet;
    @Column(name = "FielddefId")
    @JsonView(QDataView.Basic.class)
    private int fielddefId;
    @Column(name = "SectionNickNameField")
    @JsonView(QDataView.Basic.class)
    private String sectionNickNameField;
    @Column(name = "NoPage")
    @JsonView(QDataView.Basic.class)
    private String noPage;

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

    public int getStoreServerId() {
        return storeServerId;
    }

    public void setStoreServerId(int storeServerId) {
        this.storeServerId = storeServerId;
    }

    public String getQuestionaireOwner() {
        return questionaireOwner;
    }

    public void setQuestionaireOwner(String questionaireOwner) {
        this.questionaireOwner = questionaireOwner;
    }

    public int getQuestionaireType_Id() {
        return questionaireType_Id;
    }

    public void setQuestionaireType_Id(int questionaireType_Id) {
        this.questionaireType_Id = questionaireType_Id;
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

    public int getcQuestionaireSet() {
        return cQuestionaireSet;
    }

    public void setcQuestionaireSet(int cQuestionaireSet) {
        this.cQuestionaireSet = cQuestionaireSet;
    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int order_Number) {
        Order_Number = order_Number;
    }

    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
    }

    public String getSecID() {
        return secID;
    }

    public void setSecID(String secID) {
        this.secID = secID;
    }

    public String getSectionLogo() {
        return sectionLogo;
    }

    public void setSectionLogo(String sectionLogo) {
        this.sectionLogo = sectionLogo;
    }

    public String getSectionText() {
        return sectionText;
    }

    public void setSectionText(String sectionText) {
        this.sectionText = sectionText;
    }

    public int getOrder() {
        return Order_Number;
    }

    public void setOrder(int order) {
        this.Order_Number = order;
    }

    public int getSectionSet() {
        return sectionSet;
    }

    public void setSectionSet(int sectionSet) {
        this.sectionSet = sectionSet;
    }

    public int getFielddefId() {
        return fielddefId;
    }

    public void setFielddefId(int fielddefId) {
        this.fielddefId = fielddefId;
    }

    public String getSectionNickNameField() {
        return sectionNickNameField;
    }

    public void setSectionNickNameField(String sectionNickNameField) {
        this.sectionNickNameField = sectionNickNameField;
    }

    public String getNoPage() {
        return noPage;
    }

    public void setNoPage(String noPage) {
        this.noPage = noPage;
    }
}
