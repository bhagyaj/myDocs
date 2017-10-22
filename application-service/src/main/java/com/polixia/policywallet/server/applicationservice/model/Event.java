package com.polixia.policywallet.server.applicationservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Event  implements Serializable {

    private String applicationId;

    private String policyId;

    private String eventId;

    private Integer eventTypeId;

    private String eventType;

    private String triggerEventId;

    private Integer questionaireTypeId;

    private String contentDef;

    private Integer svrUsersId;

    private String user;

    private Date serverSync;

    private Date created;

    private Date submitted;

    private Date effective;

    private Date compliance;

    private Integer index;

    private String description;

    private List<EventData> eventData;

    private HEventData hierarchicalEventData;


    public HEventData getHierarchicalEventData() {
        return hierarchicalEventData;
    }

    public void setHierarchicalEventData(HEventData hierarchicalEventData) {
        this.hierarchicalEventData = hierarchicalEventData;
    }


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTriggerEventId() {
        return triggerEventId;
    }

    public void setTriggerEventId(String triggerEventId) {
        this.triggerEventId = triggerEventId;
    }

    public String getContentDef() {
        return contentDef;
    }

    public void setContentDef(String contentDef) {
        this.contentDef = contentDef;
    }

    public Date getServerSync() {
        return serverSync;
    }

    public void setServerSync(Date serverSync) {
        this.serverSync = serverSync;
    }

    public Integer getQuestionaireTypeId() {
        return questionaireTypeId;
    }

    public void setQuestionaireTypeId(Integer questionaireTypeId) {
        this.questionaireTypeId = questionaireTypeId;
    }

    public Integer getSvrUsersId() {
        return svrUsersId;
    }

    public void setSvrUsersId(Integer svrUsersId) {
        this.svrUsersId = svrUsersId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getEffective() {
        return effective;
    }

    public void setEffective(Date effective) {
        this.effective = effective;
    }

    public Date getCompliance() {
        return compliance;
    }

    public void setCompliance(Date compliance) {
        this.compliance = compliance;
    }

    public List<EventData> getEventData() {
        return eventData;
    }

    public void setEventData(List<EventData> eventData) {

        this.eventData = eventData;


    }

    public String getDescription() {
        return description;
    }

    //	@PostLoad
    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
