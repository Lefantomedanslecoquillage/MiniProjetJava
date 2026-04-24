import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vol {
    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private LocalDateTime dateHeureDepart;
    private LocalDateTime dateHeureArrivee;
    private String etat;

    private Avion avion;
    private Pilote pilote;
    private List<PersonnelCabine> personnelsCabine = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public Vol(String numeroVol, Aeroport origine, Aeroport destination,
               LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "PLANIFIE";
    }

    public void planifierVol() {
        this.etat = "PLANIFIE";
        if (origine != null) {
            origine.affecterVol(this);
        }
        if (destination != null) {
            destination.affecterVol(this);
        }
    }

    public void annulerVol() {
        this.etat = "ANNULE";
    }

    public void modifierVol(Aeroport origine, Aeroport destination,
                            LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee) {
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public List<Passager> ListingPassager() {
        List<Passager> passagers = new ArrayList<>();
        for (Reservation r : reservations) {
            if (!r.getStatut().equals("ANNULEE")) {
                passagers.add(r.getPassager());
            }
        }
        return passagers;
    }

    public void ajouterReservation(Reservation reservation) {
        if (reservation != null && !reservations.contains(reservation)) {
            reservations.add(reservation);
        }
    }

    public void supprimerReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.remove(reservation);
        }
    }

    public void ajouterPersonnelCabine(PersonnelCabine personnelCabine) {
        if (personnelCabine != null && !personnelsCabine.contains(personnelCabine)) {
            personnelsCabine.add(personnelCabine);
            personnelCabine.affecterVol(this);
        }
    }

    public void affecterPilote(Pilote pilote) {
        if (pilote != null) {
            pilote.affecterVol(this);
        }
    }

    public void affecterAvion(Avion avion) {
        if (avion != null) {
            avion.affecterVol(this);
        }
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public Aeroport getOrigine() {
        return origine;
    }

    public Aeroport getDestination() {
        return destination;
    }

    public LocalDateTime getDateHeureDepart() {
        return dateHeureDepart;
    }

    public LocalDateTime getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public String getEtat() {
        return etat;
    }

    public Avion getAvion() {
        return avion;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "numeroVol='" + numeroVol + '\'' +
                ", origine=" + (origine != null ? origine.getNom() : "null") +
                ", destination=" + (destination != null ? destination.getNom() : "null") +
                ", dateHeureDepart=" + dateHeureDepart +
                ", dateHeureArrivee=" + dateHeureArrivee +
                ", etat='" + etat + '\'' +
                ", avion=" + (avion != null ? avion.getImmatriculation() : "null") +
                ", pilote=" + (pilote != null ? pilote.getNom() : "null") +
                '}';
    }
}
