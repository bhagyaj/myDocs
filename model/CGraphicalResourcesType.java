package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cgraphicalresourcestype")
public class CGraphicalResourcesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "VersionId")
    private int versionId;
    @Column(name = "Version")
    private String version;
    @Column(name = "ResourceType")
    private String resourceType;
    @Column(name = "Description")
    private String description;
    @Column(name = "NormalizedResolution")
    private String normalizedResolution;
    @Column(name = "SampleResource")
    private String sampleResource;

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNormalizedResolution() {
        return normalizedResolution;
    }

    public void setNormalizedResolution(String normalizedResolution) {
        this.normalizedResolution = normalizedResolution;
    }

    public String getSampleResource() {
        return sampleResource;
    }

    public void setSampleResource(String sampleResource) {
        this.sampleResource = sampleResource;
    }
}
