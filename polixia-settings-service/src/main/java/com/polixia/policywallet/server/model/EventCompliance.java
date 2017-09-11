package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ceventcompliance")
public class EventCompliance {

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
    @Column(name = "StoreBrand")
    @JsonView(DataView.Basic.class)
    private String storeBrand;
    @ManyToOne
    @JoinColumn(name = "LoBSubscriptionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private LoBSubscription loBSubscription;
    @Column(name = "LoB")
    @JsonView(DataView.Basic.class)
    private String loB;
    @Column(name = "EventType")
    @JsonView(DataView.Basic.class)
    private String eventType;
    @ManyToOne
    @JoinColumn(name = "ComplianceRuleId")
    @JsonView(DataView.Basic.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private ComplianceRule cComplianceRule;
    @Column(name = "ComplianceRule")
    @JsonView(DataView.Basic.class)
    private String complianceRule;
    @Column(name = "ConsentType")
    @JsonView(DataView.Basic.class)
    private String consentType;

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

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand;
    }

    public LoBSubscription getLoBSubscription() {
        return loBSubscription;
    }

    public void setLoBSubscription(LoBSubscription loBSubscription) {
        this.loBSubscription = loBSubscription;
    }

    public String getLoB() {
        return loB;
    }

    public void setLoB(String loB) {
        this.loB = loB;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getConsentType() {
        return consentType;
    }

    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }
}
