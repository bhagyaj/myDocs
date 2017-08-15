package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cfieldtypedef")
public class CFieldTypeDef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "versionId")
    private int versionId;
    @Column(name = "Version")
    private String version;
    @Column(name = "FieldType")
    private String fieldType;
    @Column(name = "FieldDescription")
    private String fieldDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
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
}
