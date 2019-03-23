package com.spaceapi.spaceapi.controller;

import com.spaceapi.spaceapi.dao.Rocket;
import com.spaceapi.spaceapi.service.CompaniesService;
import com.spaceapi.spaceapi.service.RocketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spaceapi")
public class RocketsController {

    @Autowired
    RocketsService rocketsService;

    @Autowired
    CompaniesService companiesService;

    @GetMapping("/rockets")
    public List<Rocket> findAll() {
        return rocketsService.findAll();
    }

    @GetMapping("/rockets/{rocketId}")
    public Rocket findById(@PathVariable Long rocketId) {
        return rocketsService.findById(rocketId);
    }

    @GetMapping("/companies/{companyId}/rockets")
    public List<Rocket> findAllByCompanyId(@PathVariable Long companyId){
        return rocketsService.findAllRocketsByCompanyId(companyId);
    }

    @GetMapping("/companies/{companyId}/rockets/{rocketId}")
    public Rocket findRocketByRocketIdAndCompanyId(@PathVariable Long companyId, @PathVariable Long rocketId) {
        return rocketsService.findRocketByRocketIdAndCompanyId(companyId, rocketId);
    }
}
