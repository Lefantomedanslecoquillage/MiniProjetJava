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
        if (vol == null) {
            return null;
        }

        Reservation reservation = new Reservation(this, vol);
        reservation.confirmerReservation();
        reservations.add(reservation);
        vol.ajouterReservation(reservation);
        return reservation;
    }

    public boolean annulerReservation(String numeroReservation) {
        Reservation reservation = obtenirReservation(numeroReservation);
        if (reservation == null) {
            return false;
        }

        reservation.annulerReservation();
        if (reservation.getVol() != null) {
            reservation.getVol().supprimerReservation(reservation);
        }
        return true;
    }

    public List<Reservation> obtenirReservations() {
        return reservations;
    }

    public Reservation obtenirReservation(String numeroReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getNumeroReservation().equals(numeroReservation)) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ObtenirInfos() + ", Passeport: " + passeport;
    }

    public String getPasseport() {return passeport;}
    public void setPasseport(String passeport) {this.passeport = passeport;}
}
