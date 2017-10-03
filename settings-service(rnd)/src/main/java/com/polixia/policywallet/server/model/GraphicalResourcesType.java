package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cgraphicalresourcestype")
public class GraphicalResourcesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "VersionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private Setting cSettings;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "ResourceType")
    @JsonView(DataView.Basic.class)
    private String resourceType;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "NormalizedResolution")
    @JsonView(DataView.Basic.class)
    private String normalizedResolution;
    @Column(name = "SampleResource")
    @JsonView(DataView.Basic.class)
    private String sampleResource;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cGraphicalResourcesType")
    private Set<GraphicalResourceDef> defs;

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

    public Set<GraphicalResourceDef> getDefs() {
        return defs;
    }

    public void setDefs(Set<GraphicalResourceDef> defs) {
        this.defs = defs;
    }
}
