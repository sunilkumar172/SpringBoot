package com.sathya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.entity.VaccinationCenter;
@Repository
public interface VaccinationServiceRepo extends JpaRepository<VaccinationCenter, Integer> {

}
