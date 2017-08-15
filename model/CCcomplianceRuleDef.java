package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ccomplianceruledef")
public class CCcomplianceRuleDef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "StoreServer")
    private String storeServer;
    @Column(name = "ComplianceRuleId")
    private int complianceRuleId;
    @Column(name = "RuleName")
    private String ruleName;
    @Column(name = "Rule")
    private int rule;
    @Column(name = "QuestionaireType")
    private String questionaireType;
    @Column(name = "CardName")
    private String cardName;
    @Column(name = "SetName")
    private String SetName;
    @Column(name = "SectionName")
    private String SectionName;
    @Column(name = "PageName")
    private String PageName;
    @Column(name = "QuestionairePageFieldId")
    private int QuestionairePageFieldId;
    @Column(name = "FieldName")
    private String fieldName;
    @Column(name = "Sign")
    private String sign;
    @Column(name = "Value")
    private String value;
    @Column(name = "Operator")
    private String operator;

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

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }

    public int getComplianceRuleId() {
        return complianceRuleId;
    }

    public void setComplianceRuleId(int complianceRuleId) {
        this.complianceRuleId = complianceRuleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
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

    public int getQuestionairePageFieldId() {
        return QuestionairePageFieldId;
    }

    public void setQuestionairePageFieldId(int questionairePageFieldId) {
        this.QuestionairePageFieldId = questionairePageFieldId;
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
