package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cfieldtypedef")
public class FieldTypeDef {

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
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "FieldType")
    @JsonView(DataView.Specific.class)
    private String fieldType;
    @Column(name = "FieldDescription")
    @JsonView(DataView.Basic.class)
    private String fieldDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}
