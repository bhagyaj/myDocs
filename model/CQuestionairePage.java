package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cquestionairepage")
public class CQuestionairePage {
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
    @Column(name = "QuestionaireType")
    @JsonView(QDataView.Basic.class)
    private String QuestionaireType;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(QDataView.Basic.class)
    private String setName;
    @ManyToOne
    @JoinColumn(name = "SectionId")
    @JsonView(QDataView.QDataSummary.class)
    private CQuestionairSections cQuestionairSections;
    @Column(name = "SectionName")
    @JsonView(QDataView.Basic.class)
    private String sectionName;
    @Column(name = "PageName")
    @JsonView(QDataView.Basic.class)
    private String pageName;
    @Column(name = "OrderNumber")
    @JsonView(QDataView.Basic.class)
    private int orderNumber;
    @Column(name = "Description")
    @JsonView(QDataView.Basic.class)
    private String description;
    @Column(name = "ComplianceRuleId")
    private int complianceRuleId;
    @Column(name = "ComplianceRule")
    private String complianceRule;
    @Column(name = "PageBehavior")
    private String pageBehavior;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cQuestionairePage")
    @JsonView(QDataView.QHDataSummary.class)
    private Set<CQuestionairePageFields> fields;

    public int getId() {
        return id;
    }

    public Set<CQuestionairePageFields> getFields() {
        return fields;
    }

    public void setFields(Set<CQuestionairePageFields> fields) {
        this.fields = fields;
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
        return QuestionaireType;
    }

    public void setQuestionaireType(String questionaireType) {
        this.QuestionaireType = questionaireType;
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

    public CQuestionairSections getcQuestionairSections() {
        return cQuestionairSections;
    }

    public void setcQuestionairSections(CQuestionairSections cQuestionairSections) {
        this.cQuestionairSections = cQuestionairSections;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getOrder() {
        return orderNumber;
    }

    public void setOrder(int order) {
        this.orderNumber = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getComplianceRuleId() {
        return complianceRuleId;
    }

    public void setComplianceRuleId(int complianceRuleId) {
        this.complianceRuleId = complianceRuleId;
    }

    public String getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(String complianceRule) {
        this.complianceRule = complianceRule;
    }

    public String getPageBehavior() {
        return pageBehavior;
    }

    public void setPageBehavior(String pageBehavior) {
        this.pageBehavior = pageBehavior;
    }
}
