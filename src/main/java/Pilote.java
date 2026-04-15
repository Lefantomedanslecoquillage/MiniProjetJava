import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;
    private List<Vol> vols = new ArrayList<>();

    public Pilote(String identifiant, String nom, String adresse, String contact,
                  String numeroEmploye, LocalDate dateEmbauche,
                  String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
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
}
