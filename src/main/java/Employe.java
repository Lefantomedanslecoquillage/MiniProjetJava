import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Employe extends Personne{
    private int numeroEmploye;
    private LocalDate dateEmbauche;
    protected String role;
    public Employe(String identifiant, String nom, String adresse, String contact, int numeroEmploye, String dateEmbauche){
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = LocalDate.parse(dateEmbauche);
    }

    public void setNumeroEmploye(int numeroEmploye){this.numeroEmploye = numeroEmploye;}
    public void setDateEmbauche(String dateEmbauche){this.dateEmbauche = LocalDate.parse(dateEmbauche);}
    public int getNumeroEmploye(){return this.numeroEmploye;}
    public LocalDate getDateEmbauche(){return this.dateEmbauche;}


    public String obtenirRole() {
        ;return null;
    }
}

