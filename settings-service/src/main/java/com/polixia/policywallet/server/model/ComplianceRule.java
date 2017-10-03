package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ccompliancerules")
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Specific.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @ManyToOne
    @JoinColumn(name = "CarrierToVersionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private CarrierToVersion carrierToVersion;
    @Column(name = "Carrier")
    @JsonView(DataView.Basic.class)
    private String carrier;
    @Column(name = "ComplainceRule")
    @JsonView(DataView.Specific.class)
    private String complainceRule;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "ComplianceResource")
    @JsonView(DataView.Basic.class)
    private String complianceResource;
    @Column(name = "ConsentGroup")
    @JsonView(DataView.Basic.class)
    private String consentGroup;

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

    public CarrierToVersion getCarrierToVersion() {
        return carrierToVersion;
    }

    public void setCarrierToVersion(CarrierToVersion carrierToVersion) {
        this.carrierToVersion = carrierToVersion;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
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
