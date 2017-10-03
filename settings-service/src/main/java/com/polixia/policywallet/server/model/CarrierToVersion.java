package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carriertoversion")
public class CarrierToVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Specific.class)
    private Integer id;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer versionId;
    @ManyToOne
    @JoinColumn(name = "VersionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private Setting cSettings;
    @Column(name = "Version")
    @JsonView(DataView.Specific.class)
    private String version;
    @Column(name = "CarrierId")
    @JsonView(DataView.Basic.class)
    private Integer carrierId;
    @Column(name = "CarrierCode")
    @JsonView(DataView.Basic.class)
    private String carrierCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Setting getcSettings() {
        return cSettings;
    }

    public void setcSettings(Setting cSettings) {
        this.cSettings = cSettings;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }
}
