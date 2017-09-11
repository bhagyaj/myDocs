package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "cquestionairesections")
public class QuestionaireSection {

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
    @ManyToOne
    @JoinColumn(name = "SetId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionaireSet questionaireSet;
    @Column(name = "SetName")
    @JsonView(DataView.Basic.class)
    private String setName;
    @Column(name = "SectionName")
    @JsonView(DataView.Specific.class)
    private String sectionName;
    @Column(name = "SectionLogo")
    @JsonView(DataView.Basic.class)
    private String sectionLogo;
    @Column(name = "SectionText")
    @JsonView(DataView.Basic.class)
    private String sectionText;
    @Column(name = "OrderNumber")
    @JsonView(DataView.Basic.class)
    private Integer orderNumber;
    @Column(name = "SectionSet")
    @JsonView(DataView.Basic.class)
    private Boolean sectionSet;
    @ManyToOne
    @JoinColumn(name = "FieldDefId")
    @JsonView(DataView.ServiceSummary.class)
    private FieldDef fieldDef;
    @Column(name = "SectionNickNameField")
    @JsonView(DataView.Basic.class)
    private String sectionNickNameField;
    @Column(name = "NoPage")
    @JsonView(DataView.Basic.class)
    private Boolean noPage;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.ServiceSummary.class)
    private ComplianceRule complianceRuleObj;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.Basic.class)
    private String complianceRule;
    @Column(name = "SectionBehavior")
    @JsonView(DataView.Basic.class)
    private String sectionBehavior;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "questionaireSection")
    @JsonView(DataView.HSpecific.class)
    private Set<QuestionairePage> pages;

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

    public Set<QuestionairePage> getPages() {
        return pages;
    }

    public void setPages(Set<QuestionairePage> pages) {
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

    public QuestionaireSet getQuestionaireSet() {
        return questionaireSet;
    }

    public void setQuestionaireSet(QuestionaireSet questionaireSet) {
        this.questionaireSet = questionaireSet;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
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

    public String getSectionLogo() {
        return sectionLogo;
    }

    public void setSectionLogo(String sectionLogo) {
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

    public Boolean getSectionSet() {
        return sectionSet;
    }

    public void setSectionSet(Boolean sectionSet) {
        this.sectionSet = sectionSet;
    }

    public FieldDef getFieldDef() {
        return fieldDef;
    }

    public void setFieldDef(FieldDef fieldDef) {
        this.fieldDef = fieldDef;
    }

    public String getSectionNickNameField() {
        return sectionNickNameField;
    }

    public void setSectionNickNameField(String sectionNickNameField) {
        this.sectionNickNameField = sectionNickNameField;
    }

    public Boolean getNoPage() {
        return noPage;
    }

    public void setNoPage(Boolean noPage) {
        this.noPage = noPage;
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

    public String getSectionBehavior() {
        return sectionBehavior;
    }

    public void setSectionBehavior(String sectionBehavior) {
        this.sectionBehavior = sectionBehavior;
    }
}
