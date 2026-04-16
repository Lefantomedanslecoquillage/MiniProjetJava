import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Avion {
    private int immatriculation;
    private String modele;
    private int capacite;
    private List<Vol> volsAffectes = new ArrayList<>();

    public Avion(int immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    public void affecterVol(Vol vol){
        if (vol == null || volsAffectes.contains(vol)) {
            return;
        }

        volsAffectes.add(vol);
        vol.setAvion(this);
    }

    public boolean verifierDisponibilite(String date){
        if (date == null || date.isEmpty()) {
            return false;
        }

        LocalDate cible = LocalDate.parse(date);
        for (Vol vol : volsAffectes) {
            if (vol.getDateHeureDepart() == null || vol.getDateHeureArrivee() == null) {
                continue;
            }
            LocalDate depart = vol.getDateHeureDepart().toLocalDate();
            LocalDate arrivee = vol.getDateHeureArrivee().toLocalDate();
            if (!cible.isBefore(depart) && !cible.isAfter(arrivee)) {
                return false;
            }
        }
        return true;
    }

    public List<Vol> getVolsAffectes() {
        return volsAffectes;
    }

    public int getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
