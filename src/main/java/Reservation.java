import java.time.LocalDate;

public class Reservation {
    private static int compteur = 1;

    private String numeroReservation;
    private LocalDate dateReservation;
    private String statut;

    private Passager passager;
    private Vol vol;

    public Reservation(Passager passager, Vol vol) {
        this.numeroReservation = "R" + compteur++;
        this.dateReservation = LocalDate.now();
        this.statut = "EN_ATTENTE";
        this.passager = passager;
        this.vol = vol;
    }

    public void confirmerReservation() {
        this.statut = "CONFIRMEE";
    }

    public void annulerReservation() {
        this.statut = "ANNULEE";
    }

    public void modifierReservation(Vol nouveauVol) {
        if (nouveauVol != null && this.vol != nouveauVol) {
            if (this.vol != null) {
                this.vol.supprimerReservation(this);
            }
            this.vol = nouveauVol;
            nouveauVol.ajouterReservation(this);
        }
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public String getStatut() {
        return statut;
    }

    public Passager getPassager() {
        return passager;
    }

    public Vol getVol() {
        return vol;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroReservation='" + numeroReservation + '\'' +
                ", dateReservation=" + dateReservation +
                ", statut='" + statut + '\'' +
                ", passager=" + passager.getNom() +
                ", vol=" + (vol != null ? vol.getNumeroVol() : "aucun") +
                '}';
    }
}
