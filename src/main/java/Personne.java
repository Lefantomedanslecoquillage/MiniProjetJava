public class Personne{
    private int Identifiant;
    private String Nom;
    private String Adresse;
    private int Contact;

    public Personne(int Identifiant, String Nom, String Adresse, int Contact){
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Contact = Contact;
    }

    public void ObtenirInfos(){
        System.out.println("L'identifiant de " + this.Nom + " est " + this.Identifiant + ". Son adresse est " + this.Adresse + " et son contact est " + this.Contact + ".");
    }
}

