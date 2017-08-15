package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ceventcomplianceconsent")
public class CEventComplainceConsent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Policy_Id")
    private int policy_Id;
    @Column(name = "PolicyId")
    private String policyId;
    @Column(name = "EventId")
    private String eventId;
    @Column(name = "ComplianceRuleId")
    private int complianceRuleId;
    @Column(name = "ComplianceRule")
    private String complianceRule;
    @Column(name = "ConsentedOn")
    private String consentedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolicy_Id() {
        return policy_Id;
    }

    public void setPolicy_Id(int policy_Id) {
        this.policy_Id = policy_Id;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getConsentedOn() {
        return consentedOn;
    }

    public void setConsentedOn(String consentedOn) {
        this.consentedOn = consentedOn;
    }
}
