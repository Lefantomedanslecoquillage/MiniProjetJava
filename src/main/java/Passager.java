import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne{
    private String passeport;
    private List<Reservation> listeReservations = new ArrayList<>();
    public Passager(int identifiant, String nom, String adresse, int contact, String passeport){
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    public Reservation reserverVol(Vol vol) {
        Reservation res = new Reservation("RES-" + System.currentTimeMillis(), this, vol);
        listeReservations.add(res);
        return res;
    }

    public void annulerReservation(String numeroReservation) {
        listeReservations.removeIf(r -> r.getNumeroReservation().equals(numeroReservation));
    }

    public List<Reservation> obtenirReservations() {
        return listeReservations;
    }
}
