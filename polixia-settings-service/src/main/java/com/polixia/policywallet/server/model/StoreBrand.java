package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

/**
 * Created by brupasinghe on 8/29/2017.
 */
@Entity
@Table(name = "sstorebrand")
public class StoreBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(DataView.Basic.class)
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.Basic.class)
    private String version;
    @ManyToOne
    @JoinColumn(name = "StoreServerId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private StoreServer sStoreServer;
    @Column(name = "StoreSever")
    @JsonView(DataView.Basic.class)
    private String storeServer;
    @Column(name = "StoreBrand")
    @JsonView(DataView.Basic.class)
    private String storeBrand;
    @Column(name = "Active")
    @JsonView(DataView.Basic.class)
    private Boolean active;
    @Column(name = "SalesType")
    @JsonView(DataView.Basic.class)
    private String salesType;
    @Column(name = "StoreLogo")
    @JsonView(DataView.Basic.class)
    private Blob storeLogo;
    @Column(name = "StoreBanner")
    @JsonView(DataView.Basic.class)
    private Blob storeBanner;

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

    public String getStoreBrand() {
        return storeBrand;
    }

    public void setStoreBrand(String storeBrand) {
        this.storeBrand = storeBrand;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public Blob getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(Blob storeLogo) {
        this.storeLogo = storeLogo;
    }

    public Blob getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(Blob storeBanner) {
        this.storeBanner = storeBanner;
    }

    public Integer getId() {
        return id;
    }
}
