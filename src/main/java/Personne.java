public class Personne{
    private int identifiant;
    private String nom;
    private String adresse;
    private int contact;

    public Personne(int identifiant, String nom, String adresse, int contact){
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public void obtenirInfos(){
        System.out.println("L'identifiant de " + this.nom + " est " + this.identifiant + ". Son adresse est " + this.adresse + " et son contact est " + this.contact + ".");
    }
}

