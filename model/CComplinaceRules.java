package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ccompliancerules")
public class CComplinaceRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "StoreServerId")
    private int storeServerId;
    @Column(name = "StoreServer")
    private String storeServer;
    @Column(name = "ComplainceRule")
    private String complainceRule;
    @Column(name = "Description")
    private String description;
    @Column(name = "ComplianceResource")
    private String complianceResource;
    @Column(name = "ConsentGroup")
    private String consentGroup;

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

    public int getStoreServerId() {
        return storeServerId;
    }

    public void setStoreServerId(int storeServerId) {
        this.storeServerId = storeServerId;
    }

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }

    public String getComplainceRule() {
        return complainceRule;
    }

    public void setComplainceRule(String complainceRule) {
        this.complainceRule = complainceRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplianceResource() {
        return complianceResource;
    }

    public void setComplianceResource(String complianceResource) {
        this.complianceResource = complianceResource;
    }

    public String getConsentGroup() {
        return consentGroup;
    }

    public void setConsentGroup(String consentGroup) {
        this.consentGroup = consentGroup;
    }
}
