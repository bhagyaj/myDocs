package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;
import com.polixia.policywallet.server.jview.QHData;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cquestionairecards")
public class QuestionaireCards {

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
    @JsonView(QDataView.QDataSummary.class)
    private int questionaireType;
    @Column(name = "QuestionaireTypeId")
    @JsonView(QDataView.Basic.class)
    private String questionaireTypeId;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @Column(name = "Order_Number")
    @JsonView(QDataView.Basic.class)
    private int Order_Number;
    @Column(name = "Title")
    @JsonView(QDataView.Basic.class)
    private String title;
    @Column(name = "PageLogo")
    @JsonView(QDataView.Basic.class)
    private String pageLogo;


    public int getQuestionaireType() {
        return questionaireType;
    }

    public void setQuestionaireType(int questionaireType) {
        this.questionaireType = questionaireType;
    }

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

//    public CQuestionaireType getQuestionaireType_Id() {
//        return questionaireType_Id;
//    }
//
//    public void setQuestionaireType_Id(CQuestionaireType questionaireType_Id) {
//        this.questionaireType_Id = questionaireType_Id;
//    }

    public int getOrder_Number() {
        return Order_Number;
    }

    public void setOrder_Number(int order_Number) {
        Order_Number = order_Number;
    }

    public String getQuestionaireTypeId() {
        return questionaireTypeId;
    }

    public void setQuestionaireTypeId(String questionaireTypeId) {
        this.questionaireTypeId = questionaireTypeId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getOrder() {
        return Order_Number;
    }

    public void setOrder(int order) {
        this.Order_Number = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageLogo() {
        return pageLogo;
    }

    public void setPageLogo(String pageLogo) {
        this.pageLogo = pageLogo;
    }
}
