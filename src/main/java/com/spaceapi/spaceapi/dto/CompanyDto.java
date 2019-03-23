package com.spaceapi.spaceapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dao.Headquarter;
import lombok.Data;

import java.util.Date;

@Data
public class CompanyDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("founded_date")
    private Date foundedDate;

    @JsonProperty("employees_count")
    private Integer employeesCount;

    @JsonProperty("rockets_count")
    private Integer rocketsCount;

    @JsonProperty("capsules_count")
    private Integer capsulesCount;

    @JsonProperty("launch_sites_count")
    private Integer launchSitesCount;

    @JsonProperty("test_sites_count")
    private Integer testSitesCount;

    @JsonProperty("valuation")
    private Long valuation;

    @JsonProperty("description")
    private String description;

    @JsonProperty("headquarter")
    private Headquarter headquarter;

    public CompanyDto() {}

    public CompanyDto(Company company) {
        this.name = company.getName();
        this.owner = company.getOwner();
        this.foundedDate = company.getFoundedDate();
        this.employeesCount = company.getEmployeesCount();
        this.rocketsCount = company.getRocketsCount();
        this.capsulesCount = company.getCapsulesCount();
        this.launchSitesCount = company.getLaunchSitesCount();
        this.testSitesCount = company.getTestSitesCount();
        this.valuation = company.getValuation();
        this.description = company.getDescription();
        this.headquarter = company.getHeadquarter();
    }
}
