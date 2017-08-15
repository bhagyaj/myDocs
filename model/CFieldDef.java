package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cfielddef")
public class CFieldDef {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "StoreServerId")
    private int storeServerId;
    @Column(name = "FieldOwner")
    private String fieldOwner;
    @Column(name = "FieldName")
    private String fieldName;
    @Column(name = "FieldTypeDefId")
    private int fieldTypeDefId;
    @Column(name = "FieldType")
    private String fieldType;
    @Column(name = "FieldLength")
    private String fieldLength;
    @Column(name = "FieldDescription")
    private String fieldDescription;
    @Column(name = "CheckTable")
    private String checkTable;
    @Column(name = "Lower")
    private String lower;
    @Column(name = "Upper")
    private String upper;

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

    public int getFieldTypeDefId() {
        return fieldTypeDefId;
    }

    public void setFieldTypeDefId(int fieldTypeDefId) {
        this.fieldTypeDefId = fieldTypeDefId;
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
}
