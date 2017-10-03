package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ceventsubscription")
public class EventSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "CarrierToVersion")
    @JsonView(DataView.Basic.class)
    private String storeServer;
    @Column(name = "StoreBrand")
    @JsonView(DataView.Basic.class)
    private String storeBrand;
    @ManyToOne
    @JoinColumn(name = "LoBSubscriptionId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private LoBSubscription sLoBSubscription;
    @Column(name = "LoB")
    @JsonView(DataView.Basic.class)
    private String loB;
    @ManyToOne
    @JoinColumn(name = "EventTypeDefId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private EventTypeDef cEventTypeDef;
    @Column(name = "EventType")
    @JsonView(DataView.Basic.class)
    private String eventType;
    @ManyToOne
    @JoinColumn(name = "QuestionaireTypeId")
    @JsonView(DataView.DataSummary.class)
    private QuestionaireType cQuestionaireType;
    @Column(name = "ContentDef")
    @JsonView(DataView.Basic.class)
    private String contentDef;
    @Column(name = "Notification")
    @JsonView(DataView.Basic.class)
    private Boolean notification;

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

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand;
    }

    public LoBSubscription getsLoBSubscription() {
        return sLoBSubscription;
    }

    public void setsLoBSubscription(LoBSubscription sLoBSubscription) {
        this.sLoBSubscription = sLoBSubscription;
    }

    public String getLoB() {
        return loB;
    }

    public void setLoB(String loB) {
        this.loB = loB;
    }

    public EventTypeDef getcEventTypeDef() {
        return cEventTypeDef;
    }

    public void setcEventTypeDef(EventTypeDef cEventTypeDef) {
        this.cEventTypeDef = cEventTypeDef;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public QuestionaireType getcQuestionaireType() {
        return cQuestionaireType;
    }

    public void setcQuestionaireType(QuestionaireType cQuestionaireType) {
        this.cQuestionaireType = cQuestionaireType;
    }

    public String getContentDef() {
        return contentDef;
    }

    public void setContentDef(String contentDef) {
        this.contentDef = contentDef;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }




}
