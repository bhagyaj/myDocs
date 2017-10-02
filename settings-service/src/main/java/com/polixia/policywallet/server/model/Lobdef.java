package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clobdef")
public class Lobdef {

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
    private Setting cSettings;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "LoB")
    @JsonView(DataView.Basic.class)
    private String lob;
    @Column(name = "ApplicationQuestionaire")
    @JsonView(DataView.Basic.class)
    private String applicationQuestionaire;
    @Column(name = "StoreLoBLogo")
    @JsonView(DataView.Basic.class)
    private String storeLoBLogo;
    @Column(name = "Text1")
    @JsonView(DataView.Basic.class)
    private String text1;
    @Column(name = "DisplayOrder")
    @JsonView(DataView.Basic.class)
    private Integer displayOrder;

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

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public String getApplicationQuestionaire() {
        return applicationQuestionaire;
    }

    public void setApplicationQuestionaire(String applicationQuestionaire) {
        this.applicationQuestionaire = applicationQuestionaire;
    }

    public String getStoreLoBLogo() {
        return storeLoBLogo;
    }

    public void setStoreLoBLogo(String storeLoBLogo) {
        this.storeLoBLogo = storeLoBLogo;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}
