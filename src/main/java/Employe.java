public class Employe extends Personne{
    private int NumeroEmploye;
    private String DateEmbauche;
    public Employe(int Identifiant, String Nom, String Adresse, int Contact, int NumeroEmploye, String DateEmbauche){
        super(Identifiant, Nom, Adresse, Contact);
        this.NumeroEmploye = NumeroEmploye;
        this.DateEmbauche = DateEmbauche;
    }


}

