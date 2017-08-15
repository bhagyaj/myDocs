package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cquestionaireset")
public class CQuestionaireSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.QDataSummary.class)
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
    @ManyToOne
    @JoinColumn(name = "CardId")
    @JsonView(QDataView.QDataSummary.class)
    private CQuestionaireCards cQuestionaireCards;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(QDataView.Basic.class)
    private String setName;
    @Column(name = "SetMax")
    @JsonView(QDataView.Basic.class)
    private int setMax;
    @Column(name = "Text")
    @JsonView(QDataView.Basic.class)
    private String text;
    @Column(name = "OrderNumber")
    @JsonView(QDataView.Basic.class)
    private int orderNumber;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.Basic.class)
    private int fieldDefId;
    @Column(name = "SetNickNameField")
    @JsonView(QDataView.Basic.class)
    private String setNickNameField;
    @Column(name = "NoSection")
    @JsonView(QDataView.Basic.class)
    private int noSection;
    @Column(name = "ComplianceRuleId")
    @JsonView(QDataView.Basic.class)
    private int complianceRuleId;
    @Column(name = "ComplianceRule")
    @JsonView(QDataView.Basic.class)
    private int complianceRule;
    @Column(name = "SetBehaviour")
    @JsonView(QDataView.Basic.class)
    private int setBehaviour;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cQuestionaireSet")
    @JsonView(QDataView.QHDataSummary.class)
    private Set<CQuestionairSections> sections;

    public int getId() {
        return id;
    }

    public Set<CQuestionairSections> getSections() {
        return sections;
    }

    public void setSections(Set<CQuestionairSections> sections) {
        this.sections = sections;
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

    public CQuestionaireCards getcQuestionaireCards() {
        return cQuestionaireCards;
    }

    public void setcQuestionaireCards(CQuestionaireCards cQuestionaireCards) {
        this.cQuestionaireCards = cQuestionaireCards;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
        return orderNumber;
    }

    public void setOrder(int order) {
        this.orderNumber = order;
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

    public int getComplianceRuleId() {
        return complianceRuleId;
    }

    public void setComplianceRuleId(int complianceRuleId) {
        this.complianceRuleId = complianceRuleId;
    }

    public int getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(int complianceRule) {
        this.complianceRule = complianceRule;
    }

    public int getSetBehaviour() {
        return setBehaviour;
    }

    public void setSetBehaviour(int setBehaviour) {
        this.setBehaviour = setBehaviour;
    }
}
