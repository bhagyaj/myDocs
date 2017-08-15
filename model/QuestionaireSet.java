package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cquestionaireset")
public class QuestionaireSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.QDataSummary.class)
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
    @JsonView(QDataView.QDataSummary.class)
    private int cQuestionaireCards;
    @Column(name = "CardId")
    @JsonView(QDataView.Basic.class)
    private String cardId;
    @Column(name = "SetId")
    @JsonView(QDataView.Basic.class)
    private String setId;
    @Column(name = "SetMax")
    @JsonView(QDataView.Basic.class)
    private int setMax;
    @Column(name = "Text")
    @JsonView(QDataView.Basic.class)
    private String text;
    @Column(name = "Order_Number")
    @JsonView(QDataView.Basic.class)
    private int Order_Number;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.Basic.class)
    private int fieldDefId;
    @Column(name = "SetNickNameField")
    @JsonView(QDataView.Basic.class)
    private String setNickNameField;
    @Column(name = "NoSection")
    @JsonView(QDataView.Basic.class)
    private int noSection;

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

    public int getcQuestionaireCards() {
        return cQuestionaireCards;
    }

    public void setcQuestionaireCards(int cQuestionaireCards) {
        this.cQuestionaireCards = cQuestionaireCards;
    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int order_Number) {
        Order_Number = order_Number;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public int getSetMax() {
        return setMax;
    }

    public void setSetMax(int setMax) {
        this.setMax = setMax;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return Order_Number;
    }

    public void setOrder(int order) {
        this.Order_Number = order;
    }

    public int getFieldDefId() {
        return fieldDefId;
    }

    public void setFieldDefId(int fieldDefId) {
        this.fieldDefId = fieldDefId;
    }

    public String getSetNickNameField() {
        return setNickNameField;
    }

    public void setSetNickNameField(String setNickNameField) {
        this.setNickNameField = setNickNameField;
    }

    public int getNoSection() {
        return noSection;
    }

    public void setNoSection(int noSection) {
        this.noSection = noSection;
    }
}
