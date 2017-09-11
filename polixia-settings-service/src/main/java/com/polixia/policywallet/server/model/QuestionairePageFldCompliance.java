package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cquestionairepagefldcompliance")
public class QuestionairePageFldCompliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
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
    private String setID;
    @Column(name = "SectionName")
    @JsonView(DataView.Basic.class)
    private String sectionName;
    @Column(name = "PageName")
    @JsonView(DataView.Basic.class)
    private String pageName;
    @ManyToOne
    @JoinColumn(name = "PageFieldId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionairePageField questionairePageField;
    @Column(name = "FieldName")
    @JsonView(DataView.Basic.class)
    private String fieldName;
    @ManyToOne
    @JoinColumn(name = "ComplainceRuleId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private ComplianceRule cComplianceRule;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.Basic.class)
    private String complianceRule;
    @Column(name = "FieldBehavior")
    @JsonView(DataView.Basic.class)
    private String fieldBehavior;

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

    public String getSetID() {
        return setID;
    }

    public void setSetID(String setID) {
        this.setID = setID;
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

    public QuestionairePageField getQuestionairePageField() {
        return questionairePageField;
    }

    public void setQuestionairePageField(QuestionairePageField questionairePageField) {
        this.questionairePageField = questionairePageField;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ComplianceRule getcComplianceRule() {
        return cComplianceRule;
    }

    public void setcComplianceRule(ComplianceRule cComplianceRule) {
        this.cComplianceRule = cComplianceRule;
    }

    public String getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(String complianceRule) {
        this.complianceRule = complianceRule;
    }

    public String getFieldBehavior() {
        return fieldBehavior;
    }

    public void setFieldBehavior(String fieldBehavior) {
        this.fieldBehavior = fieldBehavior;
    }
}
