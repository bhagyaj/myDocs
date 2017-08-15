package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cquestionairepagefldcompliance")
public class CQuestionairePageFldCompliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "QuestionaireOwner")
    private String questionaireOwner;
    @Column(name = "QuestionaireType")
    private String questionaireType;
    @Column(name = "CardName")
    private String cardName;
    @Column(name = "SetName")
    private String setID;
    @Column(name = "SectionName")
    private String sectionName;
    @Column(name = "PageName")
    private String pageName;
    @Column(name = "PageFieldId")
    private int pageFieldId;
    @Column(name = "FieldName")
    private String fieldName;
    @Column(name = "ComplainceRuleId")
    private int complainceRuleId;
    @Column(name = "ComplianceRule")
    private String complianceRule;
    @Column(name = "FieldBehavior")
    private String fieldBehavior;

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

    public int getPageFieldId() {
        return pageFieldId;
    }

    public void setPageFieldId(int pageFieldId) {
        this.pageFieldId = pageFieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getComplainceRuleId() {
        return complainceRuleId;
    }

    public void setComplainceRuleId(int complainceRuleId) {
        this.complainceRuleId = complainceRuleId;
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
