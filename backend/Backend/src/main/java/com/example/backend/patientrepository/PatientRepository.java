package com.example.backend.patientrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository <Patient,Integer> {

}
