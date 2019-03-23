package com.spaceapi.spaceapi.controller;

import com.spaceapi.spaceapi.dto.CompanyDto;
import com.spaceapi.spaceapi.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spaceapi")
public class CompaniesController {

    @Autowired
    CompaniesService companiesService;

    @GetMapping("/companies")
    public List<CompanyDto> findAll() {
        return companiesService.findAll();
    }

    @GetMapping("/companies/{id}")
    public CompanyDto findById(@PathVariable Long id) {
        return companiesService.findById(id);
    }


//    @GetMapping("/companies/{name}")
//    public CompanyDto findByName(@PathVariable String name) {
//        return companiesService.findByName(name);
//    }
}
