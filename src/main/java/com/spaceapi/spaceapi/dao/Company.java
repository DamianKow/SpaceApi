package com.spaceapi.spaceapi.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class Company extends AuditModel {

    public Company(String name, String owner, Date foundedDate, Integer employeesCount, Integer rocketsCount, Integer capsulesCount, Integer launchSitesCount, Integer testSitesCount, Long valuation, String description) {
        this.name = name;
        this.owner = owner;
        this.foundedDate = foundedDate;
        this.employeesCount = employeesCount;
        this.rocketsCount = rocketsCount;
        this.capsulesCount = capsulesCount;
        this.launchSitesCount = launchSitesCount;
        this.testSitesCount = testSitesCount;
        this.valuation = valuation;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    //@UniqueElements
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "founded_date")
    private Date foundedDate;

    @NotNull
    @Column(name = "employees_count")
    private Integer employeesCount;

    @NotNull
    @Column(name = "rockets_count")
    private Integer rocketsCount;

    @NotNull
    @Column(name = "capsules_count")
    private Integer capsulesCount;

    @NotNull
    @Column(name = "launch_sites_count")
    private Integer launchSitesCount;

    @NotNull
    @Column(name = "test_sites_count")
    private Integer testSitesCount;

    @NotNull
    @Column(name = "valuation")
    private Long valuation;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "company"
    )
    @JsonManagedReference
    private Headquarter headquarter;

    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "company")
    private List<Rocket> rockets;

    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "companyCapsule")
    private List<Capsule> capsules;
}
