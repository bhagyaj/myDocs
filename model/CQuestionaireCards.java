package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "cquestionairecards")
public class CQuestionaireCards {

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
    @ManyToOne
    @JoinColumn(name = "questionaireTypeId")
    @JsonView(QDataView.QDataSummary.class)
    private CQuestionaireType questionaireTypeId;
    @Column(name = "QuestionaireType")
    @JsonView(QDataView.Basic.class)
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @Column(name = "OrderNumber")
    @JsonView(QDataView.Basic.class)
    private int orderNumber;
    @Column(name = "Title")
    @JsonView(QDataView.Basic.class)
    private String title;
    @Column(name = "PageLogo")
    @JsonView(QDataView.Basic.class)
    private Blob pageLogo;
    @Column(name = "NoSet")
    @JsonView(QDataView.Basic.class)
    private boolean noSet;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cQuestionaireCards")
    @JsonView(QDataView.QHDataSummary.class)
    private Set<CQuestionaireSet> sets;

    public Set<CQuestionaireSet> getSets() {
        return sets;
    }

    public void setSets(Set<CQuestionaireSet> sets) {
        this.sets = sets;
    }

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

//    public CQuestionaireType getQuestionaireType_Id() {
//        return questionaireType_Id;
//    }
//
//    public void setQuestionaireType_Id(CQuestionaireType questionaireType_Id) {
//        this.questionaireType_Id = questionaireType_Id;
//    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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

    public int getOrder() {
        return orderNumber;
    }

    public void setOrder(int order) {
        this.orderNumber = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blob getPageLogo() {
        return pageLogo;
    }

    public void setPageLogo(Blob pageLogo) {
        this.pageLogo = pageLogo;
    }

    public boolean isNoSet() {
        return noSet;
    }

    public void setNoSet(boolean noSet) {
        this.noSet = noSet;
    }
}
