import java.util.ArrayList;
import java.util.List;



public class Employe extends Personne{
    private int numeroEmploye;
    private String dateEmbauche;
    public Employe(int identifiant, String nom, String adresse, int contact, int numeroEmploye, String dateEmbauche){
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public void setNumeroEmploye(int numeroEmploye){this.numeroEmploye = numeroEmploye;}
    public void setDateEmbauche(String dateEmbauche){this.dateEmbauche = dateEmbauche;}
    public int getNumeroEmploye(){return this.numeroEmploye;}
    public String getDateEmbauche(){return this.dateEmbauche;}


    public String obtenirRole() {
        return null;
    }
}

