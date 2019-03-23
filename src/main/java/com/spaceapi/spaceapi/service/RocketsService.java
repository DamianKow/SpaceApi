package com.spaceapi.spaceapi.service;

import com.spaceapi.spaceapi.dao.Rocket;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RocketsService {

    List<Rocket> findAll();

    Rocket findById(Long companyId);

    List<Rocket> findAllRocketsByCompanyId(Long rocketId);

    Rocket findRocketByRocketIdAndCompanyId(Long companyId, Long rocketId);

}
