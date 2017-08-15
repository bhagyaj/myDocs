package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "cquestionairsections")
public class CQuestionairSections {
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
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(QDataView.Basic.class)
    private String cardName;
    @ManyToOne
    @JoinColumn(name = "SetId")
    @JsonView(QDataView.QDataSummary.class)
    private CQuestionaireSet cQuestionaireSet;
    @Column(name = "SetName")
    @JsonView(QDataView.Basic.class)
    private String setName;
    @Column(name = "SectionName")
    @JsonView(QDataView.Basic.class)
    private String sectionName;
    @Column(name = "SectionLogo")
    @JsonView(QDataView.Basic.class)
    private Blob sectionLogo;
    @Column(name = "SectionText")
    @JsonView(QDataView.Basic.class)
    private String sectionText;
    @Column(name = "OrderNumber")
    @JsonView(QDataView.Basic.class)
    private int orderNumber;
    @Column(name = "SectionSet")
    @JsonView(QDataView.Basic.class)
    private int sectionSet;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.Basic.class)
    private int fielddefId;
    @Column(name = "SectionNickNameField")
    @JsonView(QDataView.Basic.class)
    private String sectionNickNameField;
    @Column(name = "NoPage")
    @JsonView(QDataView.Basic.class)
    private boolean noPage;
    @Column(name = "ComplianceRuleId")
    @JsonView(QDataView.Basic.class)
    private int complianceRuleId;
    @Column(name = "ComplianceRule")
    @JsonView(QDataView.Basic.class)
    private String complianceRule;
    @Column(name = "SectionBehavior")
    @JsonView(QDataView.Basic.class)
    private String sectionBehavior;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cQuestionairSections")
    @JsonView(QDataView.QHDataSummary.class)
    private Set<CQuestionairePage> pages;

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

    public Set<CQuestionairePage> getPages() {
        return pages;
    }

    public void setPages(Set<CQuestionairePage> pages) {
        this.pages = pages;
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CQuestionaireSet getcQuestionaireSet() {
        return cQuestionaireSet;
    }

    public void setcQuestionaireSet(CQuestionaireSet cQuestionaireSet) {
        this.cQuestionaireSet = cQuestionaireSet;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Blob getSectionLogo() {
        return sectionLogo;
    }

    public void setSectionLogo(Blob sectionLogo) {
        this.sectionLogo = sectionLogo;
    }

    public String getSectionText() {
        return sectionText;
    }

    public void setSectionText(String sectionText) {
        this.sectionText = sectionText;
    }

    public int getOrder() {
        return orderNumber;
    }

    public void setOrder(int order) {
        this.orderNumber = order;
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

    public boolean getNoPage() {
        return noPage;
    }

    public void setNoPage(boolean noPage) {
        this.noPage = noPage;
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

    public String getSectionBehavior() {
        return sectionBehavior;
    }

    public void setSectionBehavior(String sectionBehavior) {
        this.sectionBehavior = sectionBehavior;
    }
}
