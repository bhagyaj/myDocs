package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ctiledef")
public class TileDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer versionId;
    @ManyToOne
    @JoinColumn(name = "VersionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private Setting setting;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "Tile")
    @JsonView(DataView.Basic.class)
    private String tile;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}
