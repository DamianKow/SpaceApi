package com.spaceapi.spaceapi.repository;

import com.spaceapi.spaceapi.dao.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapsulesRepository extends JpaRepository<Capsule, Long> {
}
