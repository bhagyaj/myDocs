package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ccomplianceruledef")
public class ComplianceRuleDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "StoreServer")
    @JsonView(DataView.Basic.class)
    private String storeServer;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private ComplianceRule complianceRule;
    @Column(name = "RuleName")
    @JsonView(DataView.Basic.class)
    private String ruleName;
    @Column(name = "Rule")
    @JsonView(DataView.Basic.class)
    private Integer rule;
    @Column(name = "QuestionaireType")
    @JsonView(DataView.Basic.class)
    private String questionaireType;
    @Column(name = "CardName")
    @JsonView(DataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(DataView.Basic.class)
    private String SetName;
    @Column(name = "SectionName")
    @JsonView(DataView.Basic.class)
    private String SectionName;
    @Column(name = "PageName")
    @JsonView(DataView.Basic.class)
    private String PageName;
    @ManyToOne
    @JoinColumn(name = "QuestionairePageFieldId")
    @JsonView(DataView.Basic.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionairePageField questionairePageField;
    @Column(name = "FieldName")
    @JsonView(DataView.Basic.class)
    private String fieldName;
    @Column(name = "Sign")
    @JsonView(DataView.Basic.class)
    private String sign;
    @Column(name = "Value")
    @JsonView(DataView.Basic.class)
    private String value;
    @Column(name = "Operator")
    @JsonView(DataView.Basic.class)
    private String operator;

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

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }

    public ComplianceRule getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(ComplianceRule complianceRule) {
        this.complianceRule = complianceRule;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
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
        return SetName;
    }

    public void setSetName(String setName) {
        this.SetName = setName;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String sectionName) {
        this.SectionName = sectionName;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        this.PageName = pageName;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
