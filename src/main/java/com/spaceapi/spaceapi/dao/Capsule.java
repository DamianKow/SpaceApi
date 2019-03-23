package com.spaceapi.spaceapi.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "capsules")
public class Capsule extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "first_launch_date")
    private Date firstLaunchDate;

    @Column(name = "first_launch_timestamp")
    private Timestamp firstLaunchTimestamp;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company companyCapsule;

    private Capsule() {}

    public Capsule(Boolean isActive, Date firstLaunchDate, Timestamp firstLaunchTimestamp,
                   String type, String name, String description) {
        this.isActive = isActive;
        this.firstLaunchDate = firstLaunchDate;
        this.firstLaunchTimestamp = firstLaunchTimestamp;
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
