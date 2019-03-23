package com.spaceapi.spaceapi.repository;

import com.spaceapi.spaceapi.dao.Company;
import com.spaceapi.spaceapi.dao.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RocketsRepository extends JpaRepository<Rocket, Long> {


    @Query("select r from Rocket r where r.id=?2 and r.company.id=?1")
    public Optional<Rocket> findRocketByRocketIdAndCompanyId(Long companyId, Long rocketId);



}