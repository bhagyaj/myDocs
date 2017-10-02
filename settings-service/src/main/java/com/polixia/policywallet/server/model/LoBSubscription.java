package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "slobsubscription")
public class LoBSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @Column(name = "StoreServer")
    @JsonView(DataView.Basic.class)
    private String storeServer;
    @ManyToOne
    @JoinColumn(name = "StoreBrandId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private StoreBrand sStoreBrand;
    @Column(name = "StoreBrand")
    @JsonView(DataView.Basic.class)
    private String storeBrand;
    @Column(name = "LoB")
    @JsonView(DataView.Basic.class)
    private String lob;
    @ManyToOne
    @JoinColumn(name = "LoBDefId")
    @JsonView(DataView.DataSummary.class)
    private Lobdef cLobdef;
    @Column(name = "LoBCategory")
    @JsonView(DataView.Basic.class)
    private String lobCategory;
    @Column(name = "SalesType")
    @JsonView(DataView.Basic.class)
    private String salesType;
    @Column(name = "Active")
    @JsonView(DataView.Basic.class)
    private Boolean active;
    @Column(name = "LoBLogo")
    @JsonView(DataView.Basic.class)
    private String lobLogo;
    @Column(name = "Text1")
    @JsonView(DataView.Basic.class)
    private String text1;
    @Column(name = "Text2")
    @JsonView(DataView.Basic.class)
    private String text2;
    @Column(name = "DisplayOrder")
    @JsonView(DataView.Basic.class)
    private String displayOrder;
    @Column(name = "Bundle")
    @JsonView(DataView.Basic.class)
    private Boolean bundle;
    @Column(name = "Expiration")
    @JsonView(DataView.Basic.class)
    private Timestamp expiration;
    @Column(name = "ShieldGrey")
    @JsonView(DataView.Basic.class)
    private String shieldGrey;
    @Column(name = "ShieldProcessing")
    @JsonView(DataView.Basic.class)
    private String shieldProcessing;
    @Column(name = "ShieldQuote")
    @JsonView(DataView.Basic.class)
    private String shieldQuote;
    @Column(name = "ShieldWallet")
    @JsonView(DataView.Basic.class)
    private String shildwallet;
    @Column(name = "FileTypeLogo")
    @JsonView(DataView.Basic.class)
    private String fileTypeLogo;
    @Column(name = "ApplePay")
    @JsonView(DataView.Basic.class)
    private Boolean applePay;
    @Column(name = "ACH")
    @JsonView(DataView.Basic.class)
    private Boolean ach;
    @Column(name = "CreditCard")
    @JsonView(DataView.Basic.class)
    private Boolean creditCard;
    @ManyToOne
    @JoinColumn(name = "QuestionaireTypeId")
    @JsonView(DataView.DataSummary.class)
    private QuestionaireType brokerQuestionaireTypeId;
    @Column(name = "BrokerQuestionaire")
    @JsonView(DataView.Basic.class)
    private String brokerQuestionaire;

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

    public StoreBrand getsStoreBrand() {
        return sStoreBrand;
    }

    public void setsStoreBrand(StoreBrand sStoreBrand) {
        this.sStoreBrand = sStoreBrand;
    }

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public Lobdef getcLobdef() {
        return cLobdef;
    }

    public void setcLobdef(Lobdef cLobdef) {
        this.cLobdef = cLobdef;
    }

    public String getLobCategory() {
        return lobCategory;
    }

    public void setLobCategory(String lobCategory) {
        this.lobCategory = lobCategory;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLobLogo() {
        return lobLogo;
    }

    public void setLobLogo(String lobLogo) {
        this.lobLogo = lobLogo;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    public String getShieldGrey() {
        return shieldGrey;
    }

    public void setShieldGrey(String shieldGrey) {
        this.shieldGrey = shieldGrey;
    }

    public String getShieldProcessing() {
        return shieldProcessing;
    }

    public void setShieldProcessing(String shieldProcessing) {
        this.shieldProcessing = shieldProcessing;
    }

    public String getShieldQuote() {
        return shieldQuote;
    }

    public void setShieldQuote(String shieldQuote) {
        this.shieldQuote = shieldQuote;
    }

    public String getShildwallet() {
        return shildwallet;
    }

    public void setShildwallet(String shildwallet) {
        this.shildwallet = shildwallet;
    }

    public String getFileTypeLogo() {
        return fileTypeLogo;
    }

    public void setFileTypeLogo(String fileTypeLogo) {
        this.fileTypeLogo = fileTypeLogo;
    }

    public Boolean getApplePay() {
        return applePay;
    }

    public void setApplePay(Boolean applePay) {
        this.applePay = applePay;
    }

    public Boolean getAch() {
        return ach;
    }

    public void setAch(Boolean ach) {
        this.ach = ach;
    }

    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    public QuestionaireType getBrokerQuestionaireTypeId() {
        return brokerQuestionaireTypeId;
    }

    public void setBrokerQuestionaireTypeId(QuestionaireType brokerQuestionaireTypeId) {
        this.brokerQuestionaireTypeId = brokerQuestionaireTypeId;
    }

    public String getBrokerQuestionaire() {
        return brokerQuestionaire;
    }

    public void setBrokerQuestionaire(String brokerQuestionaire) {
        this.brokerQuestionaire = brokerQuestionaire;
    }



}
