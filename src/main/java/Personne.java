public class Personne {
    protected String identifiant;
    protected String nom;
    protected String adresse;
    protected String contact;

    public Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public String ObtenirInfos() {
        return "Identifiant: " + identifiant +
                ", Nom: " + nom +
                ", Adresse: " + adresse +
                ", Contact: " + contact;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }
}
