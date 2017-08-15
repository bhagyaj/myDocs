package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cquestionairetype")
public class CQuestionaireType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.QDataSummary.class)
    @Column(name = "Id")
    private int id;
    @Column(name = "Version")
    @JsonView(QDataView.Basic.class)
    private String version;
    @Column(name = "StoreServerId")
    @JsonView(QDataView.Basic.class)
    private int storeServerId;
    @Column(name = "QuestionaireOwner")
    @JsonView(QDataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "QuestionaireType")
    @JsonView(QDataView.Basic.class)
    private String questionaireType;
    @Column(name = "Description")
    @JsonView(QDataView.Basic.class)
    private String description;
    @Column(name = "QuestionaireId")
    @JsonView(QDataView.Basic.class)
    private int questionaireId;
    @Column(name = "FollowUpEvent")
    @JsonView(QDataView.Basic.class)
    private String followUpEvent;
    @Column(name = "ReviewSubmit")
    private boolean reviewSubmit;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "questionaireType")
    @JsonView(QDataView.QHDataSummary.class)
    private Set<CQuestionaireCards> cards;

    public int getId() {
        return id;
    }

    public Set<CQuestionaireCards> getCards() {
        return cards;
    }


    public void setCards(Set<CQuestionaireCards> cards) {
        this.cards = cards;
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

    public String getQuestionaireType() {
        return questionaireType;
    }

    public void setQuestionaireType(String questionaireType) {
        this.questionaireType = questionaireType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestionaireId() {
        return questionaireId;
    }

    public void setQuestionaireId(int questionaireId) {
        this.questionaireId = questionaireId;
    }

    public String getFollowUpEvent() {
        return followUpEvent;
    }

    public void setFollowUpEvent(String followUpEvent) {
        this.followUpEvent = followUpEvent;
    }

    public boolean isReviewSubmit() {
        return reviewSubmit;
    }

    public void setReviewSubmit(boolean reviewSubmit) {
        this.reviewSubmit = reviewSubmit;
    }
}
