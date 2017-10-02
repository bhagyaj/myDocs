package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cquestionairepage")
public class QuestionairePage {

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
    @Column(name = "QuestionaireType")
    @JsonView(DataView.Basic.class)
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(DataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(DataView.Basic.class)
    private String setName;
    @ManyToOne
    @JoinColumn(name = "SectionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionaireSection questionaireSection;
    @Column(name = "SectionName")
    @JsonView(DataView.Basic.class)
    private String sectionName;
    @Column(name = "PageName")
    @JsonView(DataView.Specific.class)
    private String pageName;
    @Column(name = "OrderNumber")
    @JsonView(DataView.Basic.class)
    private Integer orderNumber;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.ServiceSummary.class)
    private ComplianceRule complianceRuleObj;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.DataSummary.class)
    private String complianceRule;
    @Column(name = "PageBehavior")
    @JsonView(DataView.Basic.class)
    private String pageBehavior;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "questionairePage")
    @JsonView(DataView.HSpecific.class)
    private Set<QuestionairePageField> fields;

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

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public QuestionaireSection getQuestionaireSection() {
        return questionaireSection;
    }

    public void setQuestionaireSection(QuestionaireSection questionaireSection) {
        this.questionaireSection = questionaireSection;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComplianceRule getComplianceRuleObj() {
        return complianceRuleObj;
    }

    public void setComplianceRuleObj(ComplianceRule complianceRuleObj) {
        this.complianceRuleObj = complianceRuleObj;
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

    public Set<QuestionairePageField> getFields() {
        return fields;
    }

    public void setFields(Set<QuestionairePageField> fields) {
        this.fields = fields;
    }
}
