package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cquestionaireset")
public class QuestionaireSet {

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
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer questionaireCardId;
    @ManyToOne
    @JoinColumn(name = "CardId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionaireCard questionaireCard;
    @Column(name = "CardName")
    @JsonView(DataView.Basic.class)
    private String cardName;
    @Column(name = "SetName")
    @JsonView(DataView.Specific.class)
    private String setName;
    @Column(name = "SetMax")
    @JsonView(DataView.Basic.class)
    private Integer setMax;
    @Column(name = "Text")
    @JsonView(DataView.Basic.class)
    private String text;
    @Column(name = "OrderNumber")
    @JsonView(DataView.Basic.class)
    private Integer orderNumber;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer fieldDefId;
    @ManyToOne
    @JoinColumn(name = "FieldDefId")
    @JsonView(DataView.ServiceSummary.class)
    private FieldDef fieldDef;
    @Column(name = "SetNickNameField")
    @JsonView(DataView.Basic.class)
    private String setNickNameField;
    @Column(name = "NoSection")
    @JsonView(DataView.Basic.class)
    private boolean noSection;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer complianceRuleId;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.ServiceSummary.class)
    private ComplianceRule cComplianceRules;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.Basic.class)
    private String complianceRule;
    @Column(name = "SetBehaviour")
    @JsonView(DataView.Basic.class)
    private String setBehaviour;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "questionaireSet")
    @JsonView(DataView.HSpecific.class)
    private Set<QuestionaireSection> sections;

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

    public QuestionaireCard getQuestionaireCard() {
        return questionaireCard;
    }

    public void setQuestionaireCard(QuestionaireCard questionaireCard) {
        this.questionaireCard = questionaireCard;
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

    public Integer getSetMax() {
        return setMax;
    }

    public void setSetMax(Integer setMax) {
        this.setMax = setMax;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public FieldDef getFieldDef() {
        return fieldDef;
    }

    public void setFieldDef(FieldDef fieldDef) {
        this.fieldDef = fieldDef;
    }

    public String getSetNickNameField() {
        return setNickNameField;
    }

    public void setSetNickNameField(String setNickNameField) {
        this.setNickNameField = setNickNameField;
    }

    public boolean isNoSection() {
        return noSection;
    }

    public void setNoSection(boolean noSection) {
        this.noSection = noSection;
    }

    public ComplianceRule getcComplianceRules() {
        return cComplianceRules;
    }

    public void setcComplianceRules(ComplianceRule cComplianceRules) {
        this.cComplianceRules = cComplianceRules;
    }

    public String getComplianceRule() {
        return complianceRule;
    }

    public void setComplianceRule(String complianceRule) {
        this.complianceRule = complianceRule;
    }

    public String getSetBehaviour() {
        return setBehaviour;
    }

    public void setSetBehaviour(String setBehaviour) {
        this.setBehaviour = setBehaviour;
    }

    public Set<QuestionaireSection> getSections() {
        return sections;
    }

    public void setSections(Set<QuestionaireSection> sections) {
        this.sections = sections;
    }

    public Integer getQuestionaireCardId() {
        return questionaireCardId;
    }

    public void setQuestionaireCardId(Integer questionaireCardId) {
        this.questionaireCardId = questionaireCardId;
    }

    public Integer getFieldDefId() {
        return fieldDefId;
    }

    public void setFieldDefId(Integer fieldDefId) {
        this.fieldDefId = fieldDefId;
    }

    public Integer getComplianceRuleId() {
        return complianceRuleId;
    }

    public void setComplianceRuleId(Integer complianceRuleId) {
        this.complianceRuleId = complianceRuleId;
    }
}
