public class Employe extends Personne{
    private int numeroEmploye;
    private String dateEmbauche;
    public Employe(int identifiant){
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }
}

