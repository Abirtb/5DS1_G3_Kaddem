package tn.esprit.spring.kaddem.dto;
 import tn.esprit.spring.kaddem.entities.Niveau;

 import javax.persistence.EnumType;
        import javax.persistence.Enumerated;

public class EquipeDTO {
    private int idEquipe;
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }
}