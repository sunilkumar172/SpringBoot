package com.sathya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sathya.entity.VaccinationCenter;
import com.sathya.model.Citizen;
import com.sathya.model.RequiredResponse;
import com.sathya.repository.VaccinationServiceRepo;

@RestController
@RequestMapping("/vaccination")
public class VaccinationCenterController {
    @Autowired
    private VaccinationServiceRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter center) {
        VaccinationCenter savedCenter = repo.save(center);
        return new ResponseEntity<>(savedCenter, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RequiredResponse> getdata(@PathVariable int id) {
        RequiredResponse requiredResponse = new RequiredResponse();
        // First, get the Vaccination Details
        VaccinationCenter center = repo.findById(id).orElse(null);
        if (center == null) {
            return ResponseEntity.notFound().build(); // Return 404 if the vaccination center is not found
        }
        requiredResponse.setCenter(center);

        // Then, get all citizens registered to Vaccination center
        Citizen[] listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, Citizen[].class);
        requiredResponse.setCitizen(List.of(listOfCitizens)); // Convert array to List
        return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
    }
    
   
}


