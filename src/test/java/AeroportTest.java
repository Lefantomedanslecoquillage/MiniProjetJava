import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AeroportTest {

    @Test
    void constructeur_creeAeroportAvecDonnees() {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "Aéroport de Paris");

        assertEquals("CDG", aeroport.getNom());
        assertEquals("Paris", aeroport.getVille());
        assertEquals("Aéroport de Paris", aeroport.getDescription());
    }

    @Test
    void affecterVol_ajouteVolDepartEtArrivee() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport de New York");
        
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        cdg.affecterVol(vol);
        jfk.affecterVol(vol);

        assertTrue(cdg.getVolsDepart().contains(vol));
        assertTrue(jfk.getVolsArrivee().contains(vol));
    }

    @Test
    void affecterVol_neAjoutePasDoublons() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport de New York");
        
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        cdg.affecterVol(vol);
        cdg.affecterVol(vol); // Essayer d'ajouter à nouveau

        assertEquals(1, cdg.getVolsDepart().size());
    }

    @Test
    void affecterVol_null_neChange() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");

        cdg.affecterVol(null);

        assertTrue(cdg.getVolsDepart().isEmpty());
        assertTrue(cdg.getVolsArrivee().isEmpty());
    }

    @Test
    void getVolsDepart_retourneListeDesVolsDepart() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport de New York");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("AF102", cdg, jfk,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 17, 0));

        cdg.affecterVol(vol1);
        cdg.affecterVol(vol2);

        List<Vol> volsDepart = cdg.getVolsDepart();
        assertEquals(2, volsDepart.size());
        assertTrue(volsDepart.contains(vol1));
        assertTrue(volsDepart.contains(vol2));
    }

    @Test
    void getVolsArrivee_retourneListeDesVolsArrivee() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport de New York");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("AF102", cdg, jfk,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 17, 0));

        jfk.affecterVol(vol1);
        jfk.affecterVol(vol2);

        List<Vol> volsArrivee = jfk.getVolsArrivee();
        assertEquals(2, volsArrivee.size());
        assertTrue(volsArrivee.contains(vol1));
        assertTrue(volsArrivee.contains(vol2));
    }

    @Test
    void getNom_retourneLeBonNom() {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "Aéroport");
        assertEquals("CDG", aeroport.getNom());
    }

    @Test
    void getVille_retourneLaBonneVille() {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "Aéroport");
        assertEquals("Paris", aeroport.getVille());
    }

    @Test
    void getDescription_retourneLaBonneDescription() {
        Aeroport aeroport = new Aeroport("CDG", "Paris", "Principal aéroport parisien");
        assertEquals("Principal aéroport parisien", aeroport.getDescription());
    }

    @Test
    void affecterVol_volAvecOrigineAeroport() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        cdg.affecterVol(vol);

        assertTrue(cdg.getVolsDepart().contains(vol));
        assertFalse(cdg.getVolsArrivee().contains(vol));
    }

    @Test
    void affecterVol_volAvecDestinationAeroport() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        jfk.affecterVol(vol);

        assertTrue(jfk.getVolsArrivee().contains(vol));
        assertFalse(jfk.getVolsDepart().contains(vol));
    }

    @Test
    void aeroportAvecMultiplesVolsDepartEtArrivee() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Aeroport lhr = new Aeroport("LHR", "Londres", "Aéroport");
        
        Vol vol1 = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        Vol vol2 = new Vol("BA102", lhr, cdg,
                LocalDateTime.of(2026, 5, 2, 9, 0),
                LocalDateTime.of(2026, 5, 2, 14, 0));

        cdg.affecterVol(vol1);
        cdg.affecterVol(vol2);

        assertEquals(1, cdg.getVolsDepart().size());
        assertEquals(1, cdg.getVolsArrivee().size());
    }
}
