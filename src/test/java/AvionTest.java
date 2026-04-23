import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    @Test
    void verifierDisponibilite_retourneFalseSiDateDansPeriodeDunVolAffecte() {
        Avion avion = new Avion(1234, "A320", 180);
        Vol vol = creerVol("AF300", 2026, 7, 2, 2026, 7, 2);
        avion.affecterVol(vol);

        boolean disponible = avion.verifierDisponibilite("2026-07-02");

        assertFalse(disponible);
    }

    @Test
    void verifierDisponibilite_retourneTrueSiDateHorsPeriodeDunVolAffecte() {
        Avion avion = new Avion(1235, "A321", 200);
        Vol vol = creerVol("AF301", 2026, 7, 2, 2026, 7, 2);
        avion.affecterVol(vol);

        boolean disponible = avion.verifierDisponibilite("2026-07-05");

        assertTrue(disponible);
    }

    @Test
    void verifierDisponibilite_retourneFalseSiDateInvalideOuVide() {
        Avion avion = new Avion(1236, "B737", 160);

        assertFalse(avion.verifierDisponibilite(null));
        assertFalse(avion.verifierDisponibilite(""));
    }

    private Vol creerVol(String numeroVol, int anneeDepart, int moisDepart, int jourDepart,
                         int anneeArrivee, int moisArrivee, int jourArrivee) {
        Aeroport origine = new Aeroport("FRA", "Francfort", "Origine");
        Aeroport destination = new Aeroport("MAD", "Madrid", "Destination");
        return new Vol(
                numeroVol,
                origine,
                destination,
                LocalDateTime.of(anneeDepart, moisDepart, jourDepart, 10, 0),
                LocalDateTime.of(anneeArrivee, moisArrivee, jourArrivee, 14, 0)
        );
    }
}

