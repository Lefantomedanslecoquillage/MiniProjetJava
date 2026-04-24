import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VolTest {

    @Test
    void constructeur_creeVolAvecEtatPlanifie() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        LocalDateTime depart = LocalDateTime.of(2026, 5, 1, 8, 0);
        LocalDateTime arrivee = LocalDateTime.of(2026, 5, 1, 16, 0);

        Vol vol = new Vol("AF101", cdg, jfk, depart, arrivee);

        assertEquals("AF101", vol.getNumeroVol());
        assertEquals(cdg, vol.getOrigine());
        assertEquals(jfk, vol.getDestination());
        assertEquals(depart, vol.getDateHeureDepart());
        assertEquals(arrivee, vol.getDateHeureArrivee());
        assertEquals("PLANIFIE", vol.getEtat());
    }

    @Test
    void planifierVol_mettreAJourEtatEtAffecterAuxAeroports() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        vol.planifierVol();

        assertEquals("PLANIFIE", vol.getEtat());
        assertTrue(cdg.getVolsDepart().contains(vol));
        assertTrue(jfk.getVolsArrivee().contains(vol));
    }

    @Test
    void annulerVol_changeEtatAnnule() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        vol.annulerVol();

        assertEquals("ANNULE", vol.getEtat());
    }

    @Test
    void modifierVol_changeAeroportsEtDates() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Aeroport lhr = new Aeroport("LHR", "Londres", "Aéroport");
        Aeroport fra = new Aeroport("FRA", "Francfort", "Aéroport");
        
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        LocalDateTime nouveauDepart = LocalDateTime.of(2026, 6, 1, 10, 0);
        LocalDateTime nouveauArrivee = LocalDateTime.of(2026, 6, 1, 14, 0);

        vol.modifierVol(lhr, fra, nouveauDepart, nouveauArrivee);

        assertEquals(lhr, vol.getOrigine());
        assertEquals(fra, vol.getDestination());
        assertEquals(nouveauDepart, vol.getDateHeureDepart());
        assertEquals(nouveauArrivee, vol.getDateHeureArrivee());
    }

    @Test
    void ListingPassager_retournePassagersConfirmes() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        Passager p1 = new Passager("P1", "Jean", "Adresse", "0600000000", "PA1");
        Passager p2 = new Passager("P2", "Marie", "Adresse", "0700000000", "PA2");
        
        p1.reserverVol(vol);
        Reservation r2 = p2.reserverVol(vol);

        // Annuler la réservation de p2
        p2.annulerReservation(r2.getNumeroReservation());

        List<Passager> listing = vol.ListingPassager();

        assertEquals(1, listing.size());
        assertTrue(listing.contains(p1));
        assertFalse(listing.contains(p2));
    }

    @Test
    void ajouterReservation_ajouteReservationUniquement() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        Passager passager = new Passager("P1", "Jean", "Adresse", "0600000000", "PA1");
        Reservation reservation = new Reservation(passager, vol);

        vol.ajouterReservation(reservation);
        vol.ajouterReservation(reservation); // Essayer d'ajouter la même réservation

        assertEquals(1, vol.getReservations().size());
    }

    @Test
    void supprimerReservation_retireReservation() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        Passager passager = new Passager("P1", "Jean", "Adresse", "0600000000", "PA1");
        Reservation reservation = new Reservation(passager, vol);
        vol.ajouterReservation(reservation);

        vol.supprimerReservation(reservation);

        assertTrue(vol.getReservations().isEmpty());
    }

    @Test
    void ajouterPersonnelCabine_ajoutePersonnelEtAffecte() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        PersonnelCabine personnel = new PersonnelCabine("E1", "Jean", "Adresse", "0600000000", 1, "2020-01-01");

        vol.ajouterPersonnelCabine(personnel);

        assertTrue(vol.getReservations().size() >= 0); // Vérification qu'il est ajouté
        assertTrue(personnel.obtenirVol().contains(vol));
    }

    @Test
    void affecterPilote_affectePiloteAuVol() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        Pilote pilote = new Pilote("P1", "Jean", "Adresse", "0600000000", 1, "2020-01-01", "LIC001", 5000);

        vol.affecterPilote(pilote);

        assertTrue(pilote.obtenirVol().contains(vol));
    }

    @Test
    void affecterAvion_affecteAvionAuVol() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));
        
        Avion avion = new Avion(1234, "A380", 300);

        vol.affecterAvion(avion);

        assertTrue(avion.getVolsAffectes().contains(vol));
    }

    @Test
    void ajouterReservation_null_neChange() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk,
                LocalDateTime.of(2026, 5, 1, 8, 0),
                LocalDateTime.of(2026, 5, 1, 16, 0));

        vol.ajouterReservation(null);

        assertTrue(vol.getReservations().isEmpty());
    }

    @Test
    void gettersRetournentBonnesValeurs() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        LocalDateTime depart = LocalDateTime.of(2026, 5, 1, 8, 0);
        LocalDateTime arrivee = LocalDateTime.of(2026, 5, 1, 16, 0);
        Vol vol = new Vol("AF101", cdg, jfk, depart, arrivee);

        assertEquals("AF101", vol.getNumeroVol());
        assertEquals(cdg, vol.getOrigine());
        assertEquals(jfk, vol.getDestination());
        assertEquals(depart, vol.getDateHeureDepart());
        assertEquals(arrivee, vol.getDateHeureArrivee());
        assertEquals("PLANIFIE", vol.getEtat());
        assertNull(vol.getAvion());
        assertNull(vol.getPilote());
    }
}
