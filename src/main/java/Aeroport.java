import java.util.ArrayList;
import java.util.List;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    private List<Vol> volsDepart = new ArrayList<>();
    private List<Vol> volsArrivee = new ArrayList<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    public void affecterVol(Vol vol) {
        if (vol == null) {
            return;
        }

        if (vol.getOrigine() == this && !volsDepart.contains(vol)) {
            volsDepart.add(vol);
        }

        if (vol.getDestination() == this && !volsArrivee.contains(vol)) {
            volsArrivee.add(vol);
        }
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    public List<Vol> getVolsDepart() {
        return volsDepart;
    }

    public List<Vol> getVolsArrivee() {
        return volsArrivee;
    }
}
