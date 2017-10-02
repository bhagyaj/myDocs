package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;

import java.util.List;

public class Compliance {
    @JsonView(DataView.Basic.class)
    private Integer version;
    @JsonView(DataView.Basic.class)
    private List<ComplianceRule> cComplianceRules;
    @JsonView(DataView.Basic.class)
    private List<ComplianceRuleDef> cComplianceRuleDefs;
    @JsonView(DataView.Basic.class)
    private List<EventCompliance> cEventCompliances;
    @JsonView(DataView.Basic.class)
    private List<QuestionairePageFldCompliance> cQuestionairePageFldCompliances;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<ComplianceRule> getcComplianceRules() {
        return cComplianceRules;
    }

    public void setcComplianceRules(List<ComplianceRule> cComplianceRules) {
        this.cComplianceRules = cComplianceRules;
    }

    public List<ComplianceRuleDef> getcComplianceRuleDefs() {
        return cComplianceRuleDefs;
    }

    public void setcComplianceRuleDefs(List<ComplianceRuleDef> cComplianceRuleDefs) {
        this.cComplianceRuleDefs = cComplianceRuleDefs;
    }

    public List<EventCompliance> getcEventCompliances() {
        return cEventCompliances;
    }

    public void setcEventCompliances(List<EventCompliance> cEventCompliances) {
        this.cEventCompliances = cEventCompliances;
    }

    public List<QuestionairePageFldCompliance> getcQuestionairePageFldCompliances() {
        return cQuestionairePageFldCompliances;
    }

    public void setcQuestionairePageFldCompliances(List<QuestionairePageFldCompliance> cQuestionairePageFldCompliances) {
        this.cQuestionairePageFldCompliances = cQuestionairePageFldCompliances;
    }
}
