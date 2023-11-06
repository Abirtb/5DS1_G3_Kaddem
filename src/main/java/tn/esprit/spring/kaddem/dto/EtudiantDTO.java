package tn.esprit.spring.kaddem.dto;

import tn.esprit.spring.kaddem.entities.Option;

public class EtudiantDTO {
    private String nomE;
    private String prenomE;
    private Option op; // Assuming Option is an enum

    // Getters and setters for the fields

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public Option getOp() {
        return op;
    }

    public void setOp(Option op) {
        this.op = op;
    }
}

