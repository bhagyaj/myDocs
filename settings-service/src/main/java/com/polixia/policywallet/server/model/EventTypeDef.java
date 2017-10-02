package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ceventtypedef")
public class EventTypeDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Specific.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "FieldOwner")
    @JsonView(DataView.Basic.class)
    private String fieldOwner;
    @Column(name = "EventType")
    @JsonView(DataView.Specific.class)
    private String eventType;
    @Transient
    @JsonView(DataView.Basic.class)
    private Integer questionaireTypeId;
    @ManyToOne
    @JoinColumn(name = "QuestionaireTypeId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private QuestionaireType questionaireType;
    @Column(name = "ContentDef")
    @JsonView(DataView.Basic.class)
    private String contentDef;
    @Column(name = "WalletTile")
    @JsonView(DataView.Basic.class)
    private String walletTile;
    @Column(name = "StoreTile")
    @JsonView(DataView.Basic.class)
    private String storeTile;
    @Column(name = "Originator")
    @JsonView(DataView.Basic.class)
    private String originator;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "Hidden")
    @JsonView(DataView.Basic.class)
    private Boolean hidden;

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

    public QuestionaireType getQuestionaireType() {
        return questionaireType;
    }

    public void setQuestionaireType(QuestionaireType questionaireType) {
        this.questionaireType = questionaireType;
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

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getQuestionaireTypeId() {
        return questionaireTypeId;
    }

    public void setQuestionaireTypeId(Integer questionaireTypeId) {
        this.questionaireTypeId = questionaireTypeId;
    }
}
