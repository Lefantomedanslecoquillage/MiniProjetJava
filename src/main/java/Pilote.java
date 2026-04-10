public class Pilote extends Employe {
    private int licence;
    private String heuresDeVol;
    public Pilote(int identifiant, String nom, String adresse, int contact, int numeroEmploye, String dateEmbauche, int licence, String heuresDeVol){
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public void affecterVol(){
    }

    @Override
    public String obtenirRole(){
        return "Pilote";
    }
}
