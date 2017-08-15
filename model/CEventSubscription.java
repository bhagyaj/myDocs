package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ceventsubscription")
public class CEventSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "StoreServer")
    private String storeServer;
    @Column(name = "StoreBrand")
    private String storeBrand;
    @Column(name = "LoBSubscriptionId")
    private int loBId;
    @Column(name = "LoB")
    private String loB;
    @Column(name = "EventType")
    private String eventType;
    @Column(name = "QuestionaireTypeId")
    private int questionaireTypeId;
    @Column(name = "ContentDef")
    private int contentDef;
    @Column(name = "Notification")
    private boolean notification;

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

    public int getLoBId() {
        return loBId;
    }

    public void setLoBId(int loBId) {
        this.loBId = loBId;
    }

    public String getLoB() {
        return loB;
    }

    public void setLoB(String loB) {
        this.loB = loB;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getQuestionaireTypeId() {
        return questionaireTypeId;
    }

    public void setQuestionaireTypeId(int questionaireTypeId) {
        this.questionaireTypeId = questionaireTypeId;
    }

    public int getContentDef() {
        return contentDef;
    }

    public void setContentDef(int contentDef) {
        this.contentDef = contentDef;
    }

    public boolean getNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}
