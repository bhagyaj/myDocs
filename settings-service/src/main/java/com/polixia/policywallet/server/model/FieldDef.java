package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cfielddef")
public class FieldDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Specific.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer carrierToVersionId;
    @ManyToOne
    @JoinColumn(name = "CarrierToVersionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private CarrierToVersion carrierToVersion;
    @Column(name = "FieldOwner")
    @JsonView(DataView.Specific.class)
    private String fieldOwner;
    @Column(name = "FieldName")
    @JsonView(DataView.Basic.class)
    private String fieldName;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer fieldTypeDefId;
    @ManyToOne
    @JoinColumn(name = "FieldTypeDefId")
    @JsonView(DataView.DataSummary.class)
    private FieldTypeDef fieldTypeDef;
    @Column(name = "FieldType")
    @JsonView(DataView.Basic.class)
    private String fieldType;
    @Column(name = "FieldLength")
    @JsonView(DataView.Basic.class)
    private String fieldLength;
    @Column(name = "FieldDescription")
    @JsonView(DataView.Basic.class)
    private String fieldDescription;
    @Column(name = "CheckTable")
    @JsonView(DataView.Basic.class)
    private String checkTable;
    @Column(name = "Lower")
    @JsonView(DataView.Basic.class)
    private String lower;
    @Column(name = "Upper")
    @JsonView(DataView.Basic.class)
    private String upper;

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

    public String getFieldOwner() {
        return fieldOwner;
    }

    public void setFieldOwner(String fieldOwner) {
        this.fieldOwner = fieldOwner;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldTypeDef getFieldTypeDef() {
        return fieldTypeDef;
    }

    public void setFieldTypeDef(FieldTypeDef fieldTypeDef) {
        this.fieldTypeDef = fieldTypeDef;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public String getCheckTable() {
        return checkTable;
    }

    public void setCheckTable(String checkTable) {
        this.checkTable = checkTable;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public Integer getCarrierToVersionId() {
        return carrierToVersionId;
    }

    public void setCarrierToVersionId(Integer carrierToVersionId) {
        this.carrierToVersionId = carrierToVersionId;
    }

    public Integer getFieldTypeDefId() {
        return fieldTypeDefId;
    }

    public void setFieldTypeDefId(Integer fieldTypeDefId) {
        this.fieldTypeDefId = fieldTypeDefId;
    }
}
