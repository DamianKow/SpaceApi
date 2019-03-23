package com.spaceapi.spaceapi.repository;

import com.spaceapi.spaceapi.dao.Headquarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadquartersRepository extends JpaRepository<Headquarter, Long> {
}
