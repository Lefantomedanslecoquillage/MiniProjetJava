import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;
    private List<Vol> vols = new ArrayList<>();

    public Pilote(String identifiant, String nom, String adresse, String contact,
                  int numeroEmploye, String dateEmbauche,
                  String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    public void affecterVol(Vol vol) {
        if (vol != null && !vols.contains(vol)) {
            vols.add(vol);
            vol.setPilote(this);
        }
    }

    public List<Vol> obtenirVol() {
        return vols;
    }
    public String getLicence() {return licence;}
    public void setLicence(String licence) {this.licence = licence;}
    public int getHeuresDeVol() {return heuresDeVol;}
    public void setHeuresDeVol(int heuresDeVol) {this.heuresDeVol = heuresDeVol;}
}
