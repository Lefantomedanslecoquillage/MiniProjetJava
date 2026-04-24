import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvionCompletTest {

    @Test
    void constructeur_creeAvionAvecDonnees() {
        Avion avion = new Avion(1234, "A380", 300);

        assertEquals(1234, avion.getImmatriculation());
        assertEquals("A380", avion.getModele());
        assertEquals(300, avion.getCapacite());
    }

    @Test
    void affecterVol_ajouteVolAuAvion() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        avion.affecterVol(vol);

        assertTrue(avion.getVolsAffectes().contains(vol));
        assertEquals(avion, vol.getAvion());
    }

    @Test
    void affecterVol_neAjoutePasDoublons() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        avion.affecterVol(vol);
        avion.affecterVol(vol); // Essayer d'ajouter à nouveau

        assertEquals(1, avion.getVolsAffectes().size());
    }

    @Test
    void affecterVol_null_neChange() {
        Avion avion = new Avion(1234, "A380", 300);

        avion.affecterVol(null);

        assertTrue(avion.getVolsAffectes().isEmpty());
    }

    @Test
    void getVolsAffectes_retourneListeDesVols() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("AF102", cdg, jfk,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 17, 0));

        avion.affecterVol(vol1);
        avion.affecterVol(vol2);

        List<Vol> vols = avion.getVolsAffectes();
        assertEquals(2, vols.size());
        assertTrue(vols.contains(vol1));
        assertTrue(vols.contains(vol2));
    }

    @Test
    void setImmatriculation_changeImmatriculation() {
        Avion avion = new Avion(1234, "A380", 300);

        avion.setImmatriculation(5678);

        assertEquals(5678, avion.getImmatriculation());
    }

    @Test
    void setModele_changeModele() {
        Avion avion = new Avion(1234, "A380", 300);

        avion.setModele("B747");

        assertEquals("B747", avion.getModele());
    }

    @Test
    void setCapacite_changeCapacite() {
        Avion avion = new Avion(1234, "A380", 300);

        avion.setCapacite(400);

        assertEquals(400, avion.getCapacite());
    }

    @Test
    void verifierDisponibilite_retourneFalseSiDateDansPeriodeDunVolAffecte() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 7, 2, 8, 0),
                LocalDateTime.of(2026, 7, 2, 16, 0));

        avion.affecterVol(vol);

        boolean disponible = avion.verifierDisponibilite("2026-07-02");

        assertFalse(disponible, "L'avion ne devrait pas être disponible le jour du vol");
    }

    @Test
    void verifierDisponibilite_retourneTrueSiDateHorsPeriodeDunVolAffecte() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 7, 2, 8, 0),
                LocalDateTime.of(2026, 7, 2, 16, 0));

        avion.affecterVol(vol);

        boolean disponible = avion.verifierDisponibilite("2026-07-05");

        assertTrue(disponible, "L'avion devrait être disponible en dehors de la période du vol");
    }

    @Test
    void verifierDisponibilite_retourneFalseSiDateInvalideOuVide() {
        Avion avion = new Avion(1234, "A380", 300);

        assertFalse(avion.verifierDisponibilite(null));
        assertFalse(avion.verifierDisponibilite(""));
    }

    @Test
    void verifierDisponibilite_retourneTrueSiAucunVolAffecte() {
        Avion avion = new Avion(1234, "A380", 300);

        assertTrue(avion.verifierDisponibilite("2026-07-02"));
    }

    @Test
    void avionAvecPlusieursVols() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Aeroport lhr = new Aeroport("LHR", "Londres", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("BA102", lhr, cdg,
                LocalDateTime.of(2026, 5, 5, 10, 0),
                LocalDateTime.of(2026, 5, 5, 14, 0));

        avion.affecterVol(vol1);
        avion.affecterVol(vol2);

        assertEquals(2, avion.getVolsAffectes().size());
        assertFalse(avion.verifierDisponibilite("2026-05-01"));
        assertFalse(avion.verifierDisponibilite("2026-05-05"));
        assertTrue(avion.verifierDisponibilite("2026-05-03"));
    }

    @Test
    void getters_retournentBonnesValeurs() {
        Avion avion = new Avion(9999, "A320", 200);

        assertEquals(9999, avion.getImmatriculation());
        assertEquals("A320", avion.getModele());
        assertEquals(200, avion.getCapacite());
    }

    @Test
    void verifierDisponibilite_avecVolMultiJours() {
        Avion avion = new Avion(1234, "A380", 300);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 7, 2, 8, 0),
                LocalDateTime.of(2026, 7, 5, 10, 0)); // Vol sur plusieurs jours

        avion.affecterVol(vol);

        assertFalse(avion.verifierDisponibilite("2026-07-02"));
        assertFalse(avion.verifierDisponibilite("2026-07-03"));
        assertFalse(avion.verifierDisponibilite("2026-07-04"));
        assertFalse(avion.verifierDisponibilite("2026-07-05"));
        assertTrue(avion.verifierDisponibilite("2026-07-06"));
    }
}
