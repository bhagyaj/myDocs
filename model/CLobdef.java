package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "clobdef")
public class CLobdef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "VersionId")
    private int versionId;
    @Column(name = "Version")
    private String version;
    @Column(name = "LoB")
    private String lob;
    @Column(name = "ApplicationQuestionaire")
    private String applicationQuestionaire;
    @Column(name = "StoreLoBLogo")
    private String storeLoBLogo;
    @Column(name = "Text1")
    private String text1;
    @Column(name = "DisplayOrder")
    private int displayOrder;

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

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
