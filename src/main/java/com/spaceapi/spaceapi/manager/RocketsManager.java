package com.spaceapi.spaceapi.manager;

import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dao.Rocket;
import com.spaceapi.spaceapi.repository.CompaniesRepository;
import com.spaceapi.spaceapi.repository.RocketsRepository;
import com.spaceapi.spaceapi.service.RocketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RocketsManager implements RocketsService {

    @Autowired
    RocketsRepository rocketsRepository;

    @Autowired
    CompaniesRepository companiesRepository;

    @Override
    public List<Rocket> findAll() {
        return rocketsRepository.findAll();
    }

    @Override
    public Rocket findById(Long rocketId) {
        return rocketsRepository.findById(rocketId).get();
    }

    @Override
    public List<Rocket> findAllRocketsByCompanyId(Long companyId) {
        Company company = companiesRepository.findById(companyId).get();
        return company.getRockets();
    }

    @Override
    public Rocket findRocketByRocketIdAndCompanyId(Long companyId, Long rocketId) {
        return rocketsRepository.findRocketByRocketIdAndCompanyId(companyId, rocketId).get();
    }


}
