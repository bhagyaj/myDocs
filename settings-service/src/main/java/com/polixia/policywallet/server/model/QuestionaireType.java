package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cquestionairetype")
public class QuestionaireType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataView.Specific.class)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @ManyToOne
    @JoinColumn(name = "StoreServerId")
    @JsonView(DataView.ServiceSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private StoreServer storeServer;
    @Column(name = "QuestionaireOwner")
    @JsonView(DataView.Basic.class)
    private String questionaireOwner;
    @Column(name = "QuestionaireType")
    @JsonView(DataView.Specific.class)
    private String questionaireType;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "FollowUpEvent")
    @JsonView(DataView.Basic.class)
    private String followUpEvent;
    @Column(name = "ReviewSubmit")
    @JsonView(DataView.Basic.class)
    private Boolean reviewSubmit;
    @Column(name = "Timestamp")
    @JsonView(DataView.Basic.class)
    protected Long timestamp;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "questionaireType")
    @JsonView(DataView.HSpecific.class)
    private Set<QuestionaireCard> cards;

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

    public StoreServer getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(StoreServer storeServer) {
        this.storeServer = storeServer;
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

    public String getFollowUpEvent() {
        return followUpEvent;
    }

    public void setFollowUpEvent(String followUpEvent) {
        this.followUpEvent = followUpEvent;
    }

    public Boolean getReviewSubmit() {
        return reviewSubmit;
    }

    public void setReviewSubmit(Boolean reviewSubmit) {
        this.reviewSubmit = reviewSubmit;
    }

    public Set<QuestionaireCard> getCards() {
        return cards;
    }

    public void setCards(Set<QuestionaireCard> cards) {
        this.cards = cards;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

