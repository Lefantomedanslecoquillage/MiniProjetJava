import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PiloteTest {

    @Test
    void constructeur_creePiloteAvecDonnees() {
        Pilote pilote = new Pilote("P001", "Jean Dupont", "123 Rue", "0600000000", 1, "2020-01-15", "LIC001", 5000);

        assertEquals("P001", pilote.getIdentifiant());
        assertEquals("Jean Dupont", pilote.getNom());
        assertEquals("LIC001", pilote.getLicence());
        assertEquals(5000, pilote.getHeuresDeVol());
    }

    @Test
    void obtenirRole_retournePilote() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);

        assertEquals("Pilote", pilote.obtenirRole());
    }

    @Test
    void affecterVol_ajouteVolAuPilote() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        pilote.affecterVol(vol);

        assertTrue(pilote.obtenirVol().contains(vol));
        assertEquals(pilote, vol.getPilote());
    }

    @Test
    void affecterVol_neAjoutePasDoublons() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        pilote.affecterVol(vol);
        pilote.affecterVol(vol); // Essayer d'ajouter à nouveau

        assertEquals(1, pilote.obtenirVol().size());
    }

    @Test
    void affecterVol_null_neChange() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);

        pilote.affecterVol(null);

        assertTrue(pilote.obtenirVol().isEmpty());
    }

    @Test
    void obtenirVol_retourneListeDesVols() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("AF102", cdg, jfk,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 17, 0));

        pilote.affecterVol(vol1);
        pilote.affecterVol(vol2);

        List<Vol> vols = pilote.obtenirVol();
        assertEquals(2, vols.size());
        assertTrue(vols.contains(vol1));
        assertTrue(vols.contains(vol2));
    }

    @Test
    void setLicence_changeLicence() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);

        pilote.setLicence("LIC002");

        assertEquals("LIC002", pilote.getLicence());
    }

    @Test
    void setHeuresDeVol_changeHeures() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);

        pilote.setHeuresDeVol(6000);

        assertEquals(6000, pilote.getHeuresDeVol());
    }

    @Test
    void piloteAvecPlusieursVols() {
        Pilote pilote = new Pilote("P001", "Jean", "Adresse", "0600000000", 1, "2020-01-15", "LIC001", 5000);
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Aeroport lhr = new Aeroport("LHR", "Londres", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("BA102", lhr, cdg,
                LocalDateTime.of(2026, 5, 2, 10, 0),
                LocalDateTime.of(2026, 5, 2, 14, 0));

        pilote.affecterVol(vol1);
        pilote.affecterVol(vol2);

        assertEquals(2, pilote.obtenirVol().size());
        assertEquals(pilote, vol1.getPilote());
        assertEquals(pilote, vol2.getPilote());
    }

    @Test
    void getters_retournentBonnesValeurs() {
        Pilote pilote = new Pilote("P001", "Jean Dupont", "123 Rue", "0600000000", 5, "2020-01-15", "LIC005", 7500);

        assertEquals("P001", pilote.getIdentifiant());
        assertEquals("Jean Dupont", pilote.getNom());
        assertEquals("LIC005", pilote.getLicence());
        assertEquals(7500, pilote.getHeuresDeVol());
        assertEquals(5, pilote.getNumeroEmploye());
    }
}
