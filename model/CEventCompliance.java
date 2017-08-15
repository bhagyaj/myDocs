package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ceventcompliance")
public class CEventCompliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "StoreServer")
    private String storeServer;
    @Column(name = "StoreBrand")
    private String storeBrand;
    @Column(name = "LoBSubscriptionId")
    private int loBSubscriptionId;
    @Column(name = "LoB")
    private String loB;
    @Column(name = "EventType")
    private String eventType;
    @Column(name = "ComplianceRuleId")
    private int complianceRuleId;
    @Column(name = "ComplianceRule")
    private String complianceRule;
    @Column(name = "ConsentType")
    private String consentType;

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

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand;
    }

    public int getLoBSubscriptionId() {
        return loBSubscriptionId;
    }

    public void setLoBSubscriptionId(int loBSubscriptionId) {
        this.loBSubscriptionId = loBSubscriptionId;
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

    public String getConsentType() {
        return consentType;
    }

    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }
}
