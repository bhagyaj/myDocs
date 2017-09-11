package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cgraphicalresourcedef")
public class GraphicalResourceDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @ManyToOne
    @JoinColumn(name = "GraphicalResourceTypeId")
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private GraphicalResourcesType cGraphicalResourcesType;
    @Column(name = "ResourceType")
    @JsonView(DataView.Basic.class)
    private String resourceType;
    @ManyToOne
    @JoinColumn(name = "StoreServerId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private StoreServer sStoreServer;
    @Column(name = "Owner")
    @JsonView(DataView.Basic.class)
    private String owner;
    @Column(name = "ResourceName")
    @JsonView(DataView.Basic.class)
    private String resourceName;
    @Column(name = "Platform")
    @JsonView(DataView.Basic.class)
    private String platform;
    @Column(name = "Resolution")
    @JsonView(DataView.Basic.class)
    private String resolution;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "GraphicResource")
    @JsonView(DataView.Basic.class)
    private String graphicResource;

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public StoreServer getsStoreServer() {
        return sStoreServer;
    }

    public void setsStoreServer(StoreServer sStoreServer) {
        this.sStoreServer = sStoreServer;
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

    public GraphicalResourcesType getcGraphicalResourcesType() {
        return cGraphicalResourcesType;
    }

    public void setcGraphicalResourcesType(GraphicalResourcesType cGraphicalResourcesType) {
        this.cGraphicalResourcesType = cGraphicalResourcesType;
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
