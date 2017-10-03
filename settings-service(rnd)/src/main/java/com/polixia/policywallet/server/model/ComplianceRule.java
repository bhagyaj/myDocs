package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ccompliancerules")
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Specific.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @ManyToOne
    @JoinColumn(name = "StoreServerId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private StoreServer sStoreServer;
    @Column(name = "StoreServer")
    @JsonView(DataView.Basic.class)
    private String storeServer;
    @Column(name = "ComplainceRule")
    @JsonView(DataView.Specific.class)
    private String complainceRule;
    @Column(name = "Description")
    @JsonView(DataView.Basic.class)
    private String description;
    @Column(name = "ComplianceResource")
    @JsonView(DataView.Basic.class)
    private String complianceResource;
    @Column(name = "ConsentGroup")
    @JsonView(DataView.Basic.class)
    private String consentGroup;
    @Column(name = "Timestamp")
    @JsonView(DataView.Basic.class)
    private long timestamp;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "complianceRule")
    @JsonView(DataView.Basic.class)
    List<ComplianceRuleDef> complianceRuleDefs;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "cComplianceRule")
    @JsonView(DataView.Basic.class)
    List<EventCompliance> eventCompliances;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "cComplianceRule")
    @JsonView(DataView.Basic.class)
    List<QuestionairePageFldCompliance> questionairePageFldCompliances;

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

    public StoreServer getsStoreServer() {
        return sStoreServer;
    }

    public void setsStoreServer(StoreServer sStoreServer) {
        this.sStoreServer = sStoreServer;
    }

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }

    public String getComplainceRule() {
        return complainceRule;
    }

    public void setComplainceRule(String complainceRule) {
        this.complainceRule = complainceRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplianceResource() {
        return complianceResource;
    }

    public void setComplianceResource(String complianceResource) {
        this.complianceResource = complianceResource;
    }

    public String getConsentGroup() {
        return consentGroup;
    }

    public void setConsentGroup(String consentGroup) {
        this.consentGroup = consentGroup;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ComplianceRuleDef> getComplianceRuleDefs() {
        return complianceRuleDefs;
    }

    public void setComplianceRuleDefs(List<ComplianceRuleDef> complianceRuleDefs) {
        this.complianceRuleDefs = complianceRuleDefs;
    }

    public List<EventCompliance> getEventCompliances() {
        return eventCompliances;
    }

    public void setEventCompliances(List<EventCompliance> eventCompliances) {
        this.eventCompliances = eventCompliances;
    }

    public List<QuestionairePageFldCompliance> getQuestionairePageFldCompliances() {
        return questionairePageFldCompliances;
    }

    public void setQuestionairePageFldCompliances(List<QuestionairePageFldCompliance> questionairePageFldCompliances) {
        this.questionairePageFldCompliances = questionairePageFldCompliances;
    }
}
