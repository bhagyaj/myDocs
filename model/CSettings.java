package com.polixia.policywallet.server.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "csettings")
public class CSettings {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "Id")
    private int id;
    @Column(name = "Version")
    private String version;
    @Column(name = "Description")
    private String description;
    @Column(name = "Created")
    private Date created;
    @Column(name = "Released")
    private int released;
    @Column(name = "Active")
    private int active;
    @Column(name = "Location")
    private String Location;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
