package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "ceventcomplianceconsent")
public class EventComplainceConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "PolicyId")
    @JsonView(DataView.Basic.class)
    private String policyId;
    @Column(name = "EventId")
    @JsonView(DataView.Basic.class)
    private String eventId;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private ComplianceRule cComplianceRule;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.Basic.class)
    private String complianceRule;
    @Column(name = "ConsentedOn")
    @JsonView(DataView.Basic.class)
    private Date consentedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getConsentedOn() {
        return consentedOn;
    }

    public void setConsentedOn(Date consentedOn) {
        this.consentedOn = consentedOn;
    }
}
