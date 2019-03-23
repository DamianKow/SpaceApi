package com.spaceapi.spaceapi.repository;

import com.spaceapi.spaceapi.dao.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Long> {


    @Query("select c from Company c where c.name = ?1")
    public Optional<Company> findByName(String name);


}
