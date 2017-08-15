package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ceventtypedef")
public class CEventTypeDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "FieldOwner")
    private String fieldOwner;
    @Column(name = "EventType")
    private String eventType;
    @Column(name = "QuestionaireTypeId")
    private int questionaireID;
    @Column(name = "ContentDef")
    private String contentDef;
    @Column(name = "WalletTile")
    private String walletTile;
    @Column(name = "StoreTile")
    private String storeTile;
    @Column(name = "Originator")
    private String originator;
    @Column(name = "Description")
    private String description;
    @Column(name = "Hidden")
    private int hidden;

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

    public String getFieldOwner() {
        return fieldOwner;
    }

    public void setFieldOwner(String fieldOwner) {
        this.fieldOwner = fieldOwner;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getQuestionaireID() {
        return questionaireID;
    }

    public void setQuestionaireID(int questionaireID) {
        this.questionaireID = questionaireID;
    }

    public String getContentDef() {
        return contentDef;
    }

    public void setContentDef(String contentDef) {
        this.contentDef = contentDef;
    }

    public String getWalletTile() {
        return walletTile;
    }

    public void setWalletTile(String walletTile) {
        this.walletTile = walletTile;
    }

    public String getStoreTile() {
        return storeTile;
    }

    public void setStoreTile(String storeTile) {
        this.storeTile = storeTile;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }
}
