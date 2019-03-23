package com.spaceapi.spaceapi.service;

import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dao.Rocket;
import com.spaceapi.spaceapi.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompaniesService {

    List<CompanyDto> findAll();

    CompanyDto findById(Long id);

    CompanyDto findByName(String name);


}

