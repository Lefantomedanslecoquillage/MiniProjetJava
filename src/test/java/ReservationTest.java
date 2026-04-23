import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void modifierReservation_deplaceLaReservationVersUnNouveauVol() {
        Passager passager = new Passager("P10", "Jean", "Adresse", "0600000000", "PX10");
        Vol volInitial = creerVol("AF200", "ORY", "NCE");
        Vol volNouveau = creerVol("AF201", "NCE", "LYS");

        Reservation reservation = passager.reserverVol(volInitial);
        reservation.modifierReservation(volNouveau);

        assertEquals(volNouveau, reservation.getVol());
        assertFalse(volInitial.ListingPassager().contains(passager));
        assertTrue(volNouveau.ListingPassager().contains(passager));
    }

    @Test
    void modifierReservation_avecNull_neChangePasLeVol() {
        Passager passager = new Passager("P11", "Alice", "Adresse", "0600000000", "PX11");
        Vol volInitial = creerVol("AF202", "TLS", "MRS");

        Reservation reservation = passager.reserverVol(volInitial);
        reservation.modifierReservation(null);

        assertEquals(volInitial, reservation.getVol());
        assertTrue(volInitial.ListingPassager().contains(passager));
    }

    private Vol creerVol(String numeroVol, String nomOrigine, String nomDestination) {
        Aeroport origine = new Aeroport(nomOrigine, "Ville", "Origine");
        Aeroport destination = new Aeroport(nomDestination, "Ville", "Destination");
        return new Vol(
                numeroVol,
                origine,
                destination,
                LocalDateTime.of(2026, 6, 10, 9, 0),
                LocalDateTime.of(2026, 6, 10, 11, 0)
        );
    }
}

