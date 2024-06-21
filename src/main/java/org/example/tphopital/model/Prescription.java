package org.example.tphopital.model;

import jakarta.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeDeMedicament;
    private int duree;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public Prescription() {
    }

    public Prescription(String typeDeMedicament, int duree) {
        this.typeDeMedicament = typeDeMedicament;
        this.duree = duree;
    }

    public Prescription(String typeDeMedicament, int duree, Consultation consultation) {
        this.typeDeMedicament = typeDeMedicament;
        this.duree = duree;
        this.consultation = consultation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDeMedicament() {
        return typeDeMedicament;
    }

    public void setTypeDeMedicament(String typeDeMedicament) {
        this.typeDeMedicament = typeDeMedicament;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", typeDeMedicament='" + typeDeMedicament + '\'' +
                ", duree=" + duree +
                '}';
    }
}
