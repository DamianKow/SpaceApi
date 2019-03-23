package com.spaceapi.spaceapi.manager;

import com.spaceapi.spaceapi.dao.Capsule;
import com.spaceapi.spaceapi.repository.CapsulesRepository;
import com.spaceapi.spaceapi.service.CapsulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapsulesManager implements CapsulesService {

    @Autowired
    CapsulesRepository capsulesRepository;

    @Override
    public List<Capsule> findAll() {
        return capsulesRepository.findAll();
    }

    @Override
    public Capsule findById(Long id) {
        return capsulesRepository.findById(id).get();
    }
}
