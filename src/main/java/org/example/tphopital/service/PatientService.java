package org.example.tphopital.service;

import org.example.tphopital.model.Patient;
import org.example.tphopital.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

public class PatientService {
    private PatientRepository patientRepository = new PatientRepository();

    public Patient add(String lastName, String firstName, LocalDate dateOfBirth, String Url) {
        Patient patient = new Patient(lastName, firstName, dateOfBirth, Url);
        System.out.println("Ajout d'un nouveau patient : " + patient);
        return patientRepository.add(patient);
    }

    public Patient findById(int id) {
        return patientRepository.finfById(id);
    }

    public Patient update(int id, String lastName, String firstName, LocalDate dateOfBirth, String Url) {
        Patient patient = patientRepository.finfById(id);
        if(patient != null){
            patient.setLastName(lastName);
            patient.setFirstName(firstName);
            patient.setDateOfBirth(dateOfBirth);
            patient.setUrl(Url);
            return patientRepository.update(patient);
        } else {
            return null;
        }
    }

    public boolean delete(int id){
        Patient patient = patientRepository.finfById(id);
        return patientRepository.delete(patient);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }
}
