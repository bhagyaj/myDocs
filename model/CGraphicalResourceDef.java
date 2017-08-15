package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "cgraphicalresourcedef")
public class CGraphicalResourceDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "VersionId")
    private int versionId;
    @Column(name = "Version")
    private String version;
    @Column(name = "GraphicalResourceTypeId")
    private int graphicalResourceTypeId;
    @Column(name = "ResourceType")
    private String resourceType;
    @Column(name = "StoreServerId")
    private int storeServerId;
    @Column(name = "Owner")
    private String owner;
    @Column(name = "ResourceName")
    private String resourceName;
    @Column(name = "Platform")
    private String platform;
    @Column(name = "Resolution")
    private String resolution;
    @Column(name = "Description")
    private String description;
    @Column(name = "GraphicResource")
    private String graphicResource;

    public int getId() {
        return id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
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

    public int getGraphicalResourceTypeId() {
        return graphicalResourceTypeId;
    }

    public void setGraphicalResourceTypeId(int graphicalResourceTypeId) {
        this.graphicalResourceTypeId = graphicalResourceTypeId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getStoreServerId() {
        return storeServerId;
    }

    public void setStoreServerId(int storeServerId) {
        this.storeServerId = storeServerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGraphicResource() {
        return graphicResource;
    }

    public void setGraphicResource(String graphicResource) {
        this.graphicResource = graphicResource;
    }
}
