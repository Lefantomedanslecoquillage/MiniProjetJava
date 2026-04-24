import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvWriterTest {

    private String cheminFichierVols = "vols_test.csv";
    private String cheminFichierPassagers = "passagers_test.csv";
    private String cheminFichierReservations = "reservations_test.csv";
    private String cheminFichierAvions = "avions_test.csv";
    private String cheminFichierAeroports = "aeroports_test.csv";

    @AfterEach
    void nettoyage() {
        supprimerFichier(cheminFichierVols);
        supprimerFichier(cheminFichierPassagers);
        supprimerFichier(cheminFichierReservations);
        supprimerFichier(cheminFichierAvions);
        supprimerFichier(cheminFichierAeroports);
    }

    @Test
    void sauvegarderVols_creeFichierAvecEnTeteEtDonnees() throws IOException {
        List<Vol> vols = new ArrayList<>();
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport de New York");
        Vol vol1 = new Vol("AF101", cdg, jfk, 
            LocalDateTime.of(2026, 5, 1, 8, 0),
            LocalDateTime.of(2026, 5, 1, 16, 0));
        vol1.planifierVol();

        vols.add(vol1);

        CsvWriter.sauvegarderVols(vols, cheminFichierVols);

        File fichier = new File(cheminFichierVols);
        assertTrue(fichier.exists(), "Le fichier CSV devrait être créé");

        List<String> lignes = lireFichier(cheminFichierVols);
        assertEquals(2, lignes.size(), "Devrait avoir 1 en-tête + 1 vol");
        assertTrue(lignes.get(0).contains("numeroVol,origine,destination"), "L'en-tête doit être correct");
        assertTrue(lignes.get(1).contains("AF101"), "Les données du vol doivent être présentes");
    }

    @Test
    void sauvegarderPassagers_creeFichierAvecPassagers() throws IOException {
        List<Passager> passagers = new ArrayList<>();
        Passager p1 = new Passager("P001", "Jean Dupont", "123 Rue de Paris", "0600000000", "PA001");
        passagers.add(p1);

        CsvWriter.sauvegarderPassagers(passagers, cheminFichierPassagers);

        File fichier = new File(cheminFichierPassagers);
        assertTrue(fichier.exists(), "Le fichier CSV des passagers devrait être créé");

        List<String> lignes = lireFichier(cheminFichierPassagers);
        assertEquals(2, lignes.size(), "Devrait avoir 1 en-tête + 1 passager");
        assertTrue(lignes.get(0).contains("identifiant,nom,adresse"), "L'en-tête doit être correct");
        assertTrue(lignes.get(1).contains("P001"), "Les données du passager doivent être présentes");
    }

    @Test
    void sauvegarderReservations_creeFichierAvecReservations() throws IOException {
        List<Reservation> reservations = new ArrayList<>();
        Aeroport cdg = new Aeroport("CDG", "Paris", "Aéroport");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport");
        Vol vol = new Vol("AF101", cdg, jfk, 
            LocalDateTime.of(2026, 5, 1, 8, 0),
            LocalDateTime.of(2026, 5, 1, 16, 0));
        Passager passager = new Passager("P001", "Jean", "Adresse", "0600000000", "PA001");
        
        Reservation r1 = passager.reserverVol(vol);
        reservations.add(r1);

        CsvWriter.sauvegarderReservations(reservations, cheminFichierReservations);

        File fichier = new File(cheminFichierReservations);
        assertTrue(fichier.exists(), "Le fichier CSV des réservations devrait être créé");

        List<String> lignes = lireFichier(cheminFichierReservations);
        assertEquals(2, lignes.size(), "Devrait avoir 1 en-tête + 1 réservation");
        assertTrue(lignes.get(0).contains("numeroReservation,dateReservation,statut"), "L'en-tête doit être correct");
    }

    @Test
    void sauvegarderAvions_creeFichierAvecAvions() throws IOException {
        List<Avion> avions = new ArrayList<>();
        Avion avion1 = new Avion(1234, "A380", 300);
        avions.add(avion1);

        CsvWriter.sauvegarderAvions(avions, cheminFichierAvions);

        File fichier = new File(cheminFichierAvions);
        assertTrue(fichier.exists(), "Le fichier CSV des avions devrait être créé");

        List<String> lignes = lireFichier(cheminFichierAvions);
        assertEquals(2, lignes.size(), "Devrait avoir 1 en-tête + 1 avion");
        assertTrue(lignes.get(0).contains("immatriculation,modele,capacite"), "L'en-tête doit être correct");
        assertTrue(lignes.get(1).contains("1234"), "Les données de l'avion doivent être présentes");
    }

    @Test
    void sauvegarderAeroports_creeFichierAvecAeroports() throws IOException {
        List<Aeroport> aeroports = new ArrayList<>();
        Aeroport cdg = new Aeroport("CDG", "Paris", "Principal aéroport parisien");
        aeroports.add(cdg);

        CsvWriter.sauvegarderAeroports(aeroports, cheminFichierAeroports);

        File fichier = new File(cheminFichierAeroports);
        assertTrue(fichier.exists(), "Le fichier CSV des aéroports devrait être créé");

        List<String> lignes = lireFichier(cheminFichierAeroports);
        assertEquals(2, lignes.size(), "Devrait avoir 1 en-tête + 1 aéroport");
        assertTrue(lignes.get(0).contains("nom,ville,description"), "L'en-tête doit être correct");
        assertTrue(lignes.get(1).contains("CDG"), "Les données de l'aéroport doivent être présentes");
    }

    @Test
    void sauvegarderVols_listevide_creeFichierAvecEnTeteUniquement() throws IOException {
        List<Vol> vols = new ArrayList<>();

        CsvWriter.sauvegarderVols(vols, cheminFichierVols);

        List<String> lignes = lireFichier(cheminFichierVols);
        assertEquals(1, lignes.size(), "Devrait avoir uniquement l'en-tête");
        assertTrue(lignes.get(0).contains("numeroVol,origine,destination"));
    }

    @Test
    void sauvegarderPassagers_multiplesPassagers_sauvegardeCorrectement() throws IOException {
        List<Passager> passagers = new ArrayList<>();
        passagers.add(new Passager("P001", "Jean", "Adresse1", "0600000000", "PA001"));
        passagers.add(new Passager("P002", "Marie", "Adresse2", "0700000000", "PA002"));
        passagers.add(new Passager("P003", "Pierre", "Adresse3", "0800000000", "PA003"));

        CsvWriter.sauvegarderPassagers(passagers, cheminFichierPassagers);

        List<String> lignes = lireFichier(cheminFichierPassagers);
        assertEquals(4, lignes.size(), "Devrait avoir 1 en-tête + 3 passagers");
    }

    private List<String> lireFichier(String cheminFichier) throws IOException {
        List<String> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                lignes.add(ligne);
            }
        }
        return lignes;
    }

    private void supprimerFichier(String cheminFichier) {
        File fichier = new File(cheminFichier);
        if (fichier.exists()) {
            fichier.delete();
        }
    }
}
