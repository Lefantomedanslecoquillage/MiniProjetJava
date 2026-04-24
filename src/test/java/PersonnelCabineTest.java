import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonnelCabineTest {

    @Test
    void constructeur_creePersonnelCabineAvecDonnees() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie Dupont", "123 Rue", "0600000000", 2, "2020-01-15");

        assertEquals("PC001", personnel.getIdentifiant());
        assertEquals("Marie Dupont", personnel.getNom());
        assertEquals("Personnel de cabine", personnel.getQualification());
    }

    @Test
    void obtenirRole_retournePersonnelDeCabine() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");

        assertEquals("Personnel de cabine", personnel.obtenirRole());
    }

    @Test
    void affecterVol_ajouteVolAuPersonnel() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        personnel.affecterVol(vol);

        assertTrue(personnel.obtenirVol().contains(vol));
    }

    @Test
    void affecterVol_neAjoutePasDoublons() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        personnel.affecterVol(vol);
        personnel.affecterVol(vol); // Essayer d'ajouter à nouveau

        assertEquals(1, personnel.obtenirVol().size());
    }

    @Test
    void affecterVol_null_neChange() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");

        personnel.affecterVol(null);

        assertTrue(personnel.obtenirVol().isEmpty());
    }

    @Test
    void obtenirVol_retourneListeDesVols() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("AF102", cdg, jfk,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 17, 0));

        personnel.affecterVol(vol1);
        personnel.affecterVol(vol2);

        List<Vol> vols = personnel.obtenirVol();
        assertEquals(2, vols.size());
        assertTrue(vols.contains(vol1));
        assertTrue(vols.contains(vol2));
    }

    @Test
    void getQualification_retourneLaQualification() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");

        assertEquals("Personnel de cabine", personnel.getQualification());
    }

    @Test
    void personnelCabineAvecPlusieursVols() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Aeroport lhr = new Aeroport("LHR", "Londres", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("BA102", lhr, cdg,
                LocalDateTime.of(2026, 5, 2, 10, 0),
                LocalDateTime.of(2026, 5, 2, 14, 0));
        Vol vol3 = new Vol("AF103", cdg, lhr,
                LocalDateTime.of(2026, 5, 3, 11, 0),
                LocalDateTime.of(2026, 5, 3, 15, 0));

        personnel.affecterVol(vol1);
        personnel.affecterVol(vol2);
        personnel.affecterVol(vol3);

        assertEquals(3, personnel.obtenirVol().size());
        assertTrue(personnel.obtenirVol().contains(vol1));
        assertTrue(personnel.obtenirVol().contains(vol2));
        assertTrue(personnel.obtenirVol().contains(vol3));
    }

    @Test
    void getters_retournentBonnesValeurs() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie Dupont", "123 Rue", "0600000000", 10, "2020-01-15");

        assertEquals("PC001", personnel.getIdentifiant());
        assertEquals("Marie Dupont", personnel.getNom());
        assertEquals("123 Rue", personnel.getAdresse());
        assertEquals("0600000000", personnel.getContact());
        assertEquals("Personnel de cabine", personnel.getQualification());
    }

    @Test
    void setters_modifientDonnees() {
        PersonnelCabine personnel = new PersonnelCabine("PC001", "Marie", "Adresse", "0600000000", 2, "2020-01-15");

        personnel.setIdentifiant("PC002");
        personnel.setNom("Sophie");
        personnel.setAdresse("Nouvelle Adresse");
        personnel.setContact("0700000000");

        assertEquals("PC002", personnel.getIdentifiant());
        assertEquals("Sophie", personnel.getNom());
        assertEquals("Nouvelle Adresse", personnel.getAdresse());
        assertEquals("0700000000", personnel.getContact());
    }
}
