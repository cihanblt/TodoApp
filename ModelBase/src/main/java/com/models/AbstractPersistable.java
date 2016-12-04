package com.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cihanblt on 10/20/2016.
 */
@MappedSuperclass
public abstract class AbstractPersistable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private long id;

    @Column(name = "version")
    @Version
    private long version;

    @Column(name = "is_active")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isActive = true;

    @Column(name = "creation_id")
    private long creationId;

    @Column(name = "last_updated_id")
    private long lastUpdatedId;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getCreationId() {
        return creationId;
    }

    public void setCreationId(long creationId) {
        this.creationId = creationId;
    }

    public long getLastUpdatedId() {
        return lastUpdatedId;
    }

    public void setLastUpdatedId(long lastUpdatedId) {
        this.lastUpdatedId = lastUpdatedId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
