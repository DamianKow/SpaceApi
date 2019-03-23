package com.spaceapi.spaceapi.controller;

import com.spaceapi.spaceapi.dao.Capsule;
import com.spaceapi.spaceapi.service.CapsulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/spaceapi")
public class CapsulesController {

    @Autowired
    CapsulesService capsulesService;

    @GetMapping("/capsules")
    public List<Capsule> findAll() {
        return capsulesService.findAll();
    }

    @GetMapping("/capsules/{capsuleId}")
    public Capsule findById(@PathVariable Long capsuleId) {
        return capsulesService.findById(capsuleId);
    }
}
