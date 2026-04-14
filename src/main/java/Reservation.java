import java.time.LocalDate;

public class Reservation {
    private String numeroReservation;
    private LocalDate dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    public Reservation(String numeroReservation, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = LocalDate.now();
        this.statut = "En attente";
        this.passager = passager;
        this.vol = vol;
        vol.ajouterPassager(passager);
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }
}
