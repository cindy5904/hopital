package org.example.tphopital.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dateConsultation;

    private String NomMedecin;
    @OneToMany(mappedBy = "consultation")
    private List<Prescription> prescriptions = new ArrayList<>();
    @OneToMany(mappedBy="consultation")
    private List<FicheDeSoin> fichesDeSoin = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    public Consultation() {
    }

    public Consultation(LocalDate dateConsultation, String nomMedecin) {
        this.dateConsultation = dateConsultation;
        NomMedecin = nomMedecin;
    }

    public Consultation(LocalDate dateConsultation, String nomMedecin, List<Prescription> prescriptions, List<FicheDeSoin> fichesDeSoin, Patient patient) {
        this.dateConsultation = dateConsultation;
        NomMedecin = nomMedecin;
        this.prescriptions = prescriptions;
        this.fichesDeSoin = fichesDeSoin;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<FicheDeSoin> getFichesDeSoin() {
        return fichesDeSoin;
    }

    public void setFichesDeSoin(List<FicheDeSoin> fichesDeSoin) {
        this.fichesDeSoin = fichesDeSoin;
    }

    public String getNomMedecin() {
        return NomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        NomMedecin = nomMedecin;
    }
}
