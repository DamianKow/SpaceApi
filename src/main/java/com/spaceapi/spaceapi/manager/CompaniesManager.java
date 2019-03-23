package com.spaceapi.spaceapi.manager;

import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dto.CompanyDto;
import com.spaceapi.spaceapi.repository.CompaniesRepository;
import com.spaceapi.spaceapi.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompaniesManager implements CompaniesService {

    @Autowired
    CompaniesRepository companiesRepository;

    @Override
    public List<CompanyDto> findAll() {
        List<CompanyDto> companiesDto = new ArrayList<>();
        List<Company> companies = companiesRepository.findAll();
        companies.forEach(company -> companiesDto.add(new CompanyDto(company)));

        return companiesDto;
    }

    @Override
    public CompanyDto findById(Long id) {
        Company company = companiesRepository.findById(id).get();

        return new CompanyDto(company);
    }

    @Override
    public CompanyDto findByName(String name) {
        Company company = companiesRepository.findByName(name).get();
        return new CompanyDto(company);
    }


}
