package com.polixia.policywallet.server.model;

import javax.persistence.*;

@Entity
@Table(name = "sstoreserver")
public class SStoreServer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sStoreServer")
    private int id;

    @Column(name = "StoreServer")
    private String storeServer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreServer() {
        return storeServer;
    }

    public void setStoreServer(String storeServer) {
        this.storeServer = storeServer;
    }
}
