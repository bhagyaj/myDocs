package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "cquestionairecards")
public class QuestionaireCard {

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
    @ManyToOne
    @JoinColumn(name = "questionaireTypeId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionaireType questionaireType;
    @Column(name = "QuestionaireType")
    @JsonView(DataView.Basic.class)
    private String questionaire;
    @Column(name = "CardName")
    @JsonView(DataView.Specific.class)
    private String cardName;
    @Column(name = "OrderNumber")
    @JsonView(DataView.Basic.class)
    private Integer orderNumber;
    @Column(name = "Title")
    @JsonView(DataView.Basic.class)
    private String title;
    @Column(name = "PageLogo")
    @JsonView(DataView.Basic.class)
    private String pageLogo;
    @Column(name = "NoSet")
    @JsonView(DataView.Basic.class)
    private Boolean noSet;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "questionaireCard")
    @JsonView(DataView.HSpecific.class)
    private Set<QuestionaireSet> sets;

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

    public QuestionaireType getQuestionaireType() {
        return questionaireType;
    }

    public void setQuestionaireType(QuestionaireType questionaireType) {
        this.questionaireType = questionaireType;
    }

    public String getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(String questionaire) {
        this.questionaire = questionaire;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public Boolean getNoSet() {
        return noSet;
    }

    public void setNoSet(Boolean noSet) {
        this.noSet = noSet;
    }

    public Set<QuestionaireSet> getSets() {
        return sets;
    }

    public void setSets(Set<QuestionaireSet> sets) {
        this.sets = sets;
    }

    public QuestionaireCard clone(QuestionaireCard questionaireCard){
        QuestionaireCard clone = new QuestionaireCard();
        clone.setId(questionaireCard.getId());
        clone.setVersion(questionaireCard.getVersion());
        clone.setQuestionaireOwner(questionaireCard.getQuestionaireOwner());
        clone.setQuestionaireType(questionaireCard.getQuestionaireType());
        clone.setQuestionaire(questionaireCard.getQuestionaire());
        
        clone.setCardName(questionaireCard.getCardName());
        clone.setNoSet(questionaireCard.getNoSet());
        return clone;
    }
}
