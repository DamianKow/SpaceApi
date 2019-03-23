package com.spaceapi.spaceapi.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "rockets")
public class Rocket extends AuditModel{
    public Rocket() {
    }

    public Rocket(String name, Boolean isActive, Integer boostersCount,
                  Integer costPerLaunch, Integer successFlights,
                  Integer allFlights, Date firstFlightDate,
                  Timestamp firstFlightTimestamp, Double height, Double mass, Double diameter) {
        this.name = name;
        this.isActive = isActive;
        this.boostersCount = boostersCount;
        this.costPerLaunch = costPerLaunch;
        this.successFlights = successFlights;
        this.allFlights = allFlights;
        this.firstFlightDate = firstFlightDate;
        this.firstFlightTimestamp = firstFlightTimestamp;
        this.height = height;
        this.mass = mass;
        this.diameter = diameter;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "boosters_count")
    private Integer boostersCount;

    @Column(name = "cost_per_launch")
    private Integer costPerLaunch;

    @Column(name = "success_flights")
    private Integer successFlights;

    @Column(name = "all_flights")
    private Integer allFlights;

    @Column(name = "first_flight_date")
    private Date firstFlightDate;

    @Column(name = "first_flight_timestamp")
    private Timestamp firstFlightTimestamp;

    @Column(name = "height")
    private Double height;

    @Column(name = "mass")
    private Double mass;

    @Column(name = "diameter")
    private Double diameter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company;
}
