import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
    private String passeport;
    private List<Reservation> reservations = new ArrayList<>();

    public Passager(String identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    public Reservation reserverVol(Vol vol) {
        Reservation reservation = new Reservation(this, vol);
        reservation.confirmerReservation();
        reservations.add(reservation);
        vol.ajouterReservation(reservation);
        return reservation;
    }

    public boolean annulerReservation(String numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) {
                r.annulerReservation();
                return true;
            }
        }
        return false;
    }

    public List<Reservation> obtenirReservations() {
        return reservations;
    }
}
