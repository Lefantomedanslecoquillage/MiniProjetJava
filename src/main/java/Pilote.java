import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe {
    private int licence;
    private String heuresDeVol;
    private List<Vol> volsaffectes = new ArrayList<>();

    public Pilote(int identifiant, String nom, String adresse, int contact, int numeroEmploye, String dateEmbauche, int licence, String heuresDeVol){
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public void affecterVol(Vol vol){
        volsaffectes.add(vol);
    }
    public List<Vol> obtenirVol() {
        return volsaffectes;
    }


    @Override
    public String obtenirRole(){
        return "Pilote";
    }
}
