package org.example.tphopital.model;

import jakarta.persistence.*;

@Entity
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeDeSoin;
    private int duree;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public FicheDeSoin() {
    }

    public FicheDeSoin(String typeDeSoin, int duree) {
        this.typeDeSoin = typeDeSoin;
        this.duree = duree;
    }

    public FicheDeSoin(String typeDeSoin, int duree, Consultation consultation) {
        this.typeDeSoin = typeDeSoin;
        this.duree = duree;
        this.consultation = consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDeSoin() {
        return typeDeSoin;
    }

    public void setTypeDeSoin(String typeDeSoin) {
        this.typeDeSoin = typeDeSoin;
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
        return "FicheDeSoin{" +
                "id=" + id +
                ", typeDeSoin='" + typeDeSoin + '\'' +
                ", duree=" + duree +
                '}';
    }
}
