package com.spaceapi.spaceapi.service;

import com.spaceapi.spaceapi.dao.Capsule;

import java.util.List;

public interface CapsulesService {

    List<Capsule> findAll();

    Capsule findById(Long id);

}
