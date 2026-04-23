import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassagerTest {

    @Test
    void reserverVol_creeReservationConfirmeeEtAssocieeAuVol() {
        Vol vol = creerVol("AF101");
        Passager passager = creerPassager("P1");

        Reservation reservation = passager.reserverVol(vol);

        assertNotNull(reservation);
        assertEquals("CONFIRMEE", reservation.getStatut());
        assertEquals(passager, reservation.getPassager());
        assertEquals(vol, reservation.getVol());
        assertTrue(passager.obtenirReservations().contains(reservation));
        assertTrue(vol.ListingPassager().contains(passager));
    }

    @Test
    void reserverVol_null_retourneNullEtNeCreeRien() {
        Passager passager = creerPassager("P2");

        Reservation reservation = passager.reserverVol(null);

        assertNull(reservation);
        assertTrue(passager.obtenirReservations().isEmpty());
    }

    @Test
    void annulerReservation_retireLePassagerDuVolEtChangeLeStatut() {
        Vol vol = creerVol("AF102");
        Passager passager = creerPassager("P3");
        Reservation reservation = passager.reserverVol(vol);

        boolean annulee = passager.annulerReservation(reservation.getNumeroReservation());

        assertTrue(annulee);
        assertEquals("ANNULEE", reservation.getStatut());
        assertFalse(vol.ListingPassager().contains(passager));
    }

    @Test
    void annulerReservation_inconnue_retourneFalse() {
        Passager passager = creerPassager("P4");

        boolean annulee = passager.annulerReservation("INCONNUE");

        assertFalse(annulee);
    }

    @Test
    void obtenirReservation_retourneLaBonneReservation() {
        Vol vol = creerVol("AF103");
        Passager passager = creerPassager("P5");
        Reservation reservation = passager.reserverVol(vol);

        Reservation trouvee = passager.obtenirReservation(reservation.getNumeroReservation());

        assertSame(reservation, trouvee);
    }

    @Test
    void listingPassager_exclutLesReservationsAnnulees() {
        Vol vol = creerVol("AF104");
        Passager passager1 = creerPassager("P6");
        Passager passager2 = creerPassager("P7");

        Reservation r1 = passager1.reserverVol(vol);
        passager2.reserverVol(vol);
        passager1.annulerReservation(r1.getNumeroReservation());

        List<Passager> passagersActifs = vol.ListingPassager();

        assertEquals(1, passagersActifs.size());
        assertTrue(passagersActifs.contains(passager2));
        assertFalse(passagersActifs.contains(passager1));
    }

    private Vol creerVol(String numeroVol) {
        Aeroport origine = new Aeroport("CDG", "Paris", "Origine");
        Aeroport destination = new Aeroport("JFK", "New York", "Destination");
        return new Vol(
                numeroVol,
                origine,
                destination,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0)
        );
    }

    private Passager creerPassager(String id) {
        return new Passager(id, "Nom " + id, "Adresse", "0600000000", "PA" + id);
    }
}

