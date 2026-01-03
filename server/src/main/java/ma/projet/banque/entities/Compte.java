package ma.projet.banque.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(localName = "id")
    private Long id;
    
    @JacksonXmlProperty(localName = "solde")
    private double solde;
    
    @JacksonXmlProperty(localName = "type")
    private String type;
    
    @JacksonXmlProperty(localName = "dateCreation")
    private String dateCreation;
    
    public Compte() {}
    
    public Compte(Long id, double solde, String type, String dateCreation) {
        this.id = id;
        this.solde = solde;
        this.type = type;
        this.dateCreation = dateCreation;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }
}
