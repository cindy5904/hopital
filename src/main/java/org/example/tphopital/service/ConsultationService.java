package org.example.tphopital.service;

import org.example.tphopital.model.Consultation;
import org.example.tphopital.model.Patient;
import org.example.tphopital.repository.ConsultationRepository;

import java.time.LocalDate;
import java.util.List;

public class ConsultationService {
    private ConsultationRepository consultationRepository = new ConsultationRepository();

    public Consultation add(LocalDate dateConsultation, String nomMedecin) {
        Consultation consultation = new Consultation(dateConsultation, nomMedecin);
        System.out.println("Ajout d'une nouvelle consultation : " + consultation);
        return consultationRepository.add(consultation);
    }
    public Consultation findById(int id) {
        return consultationRepository.finfById(id);
    }

    public Consultation update(int id, LocalDate dateConsultation, String nomMedecin) {
        Consultation consultation = consultationRepository.finfById(id);
        if(consultation != null){
            consultation.setDateConsultation(dateConsultation);
            consultation.setNomMedecin(nomMedecin);
            return consultationRepository.update(consultation);
        } else {
            return null;
        }
    }

    public boolean delete(int id){
        Consultation consultation = consultationRepository.finfById(id);
        return consultationRepository.delete(consultation);
    }

    public List<Consultation> findAll(){
        return consultationRepository.findAll();
    }


}
