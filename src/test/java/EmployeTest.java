import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void constructeur_creeEmployeAvecDonnees() {
        Employe employe = new Employe("E001", "Jean Dupont", "123 Rue", "0600000000", 1, "2020-01-15");

        assertEquals("E001", employe.getIdentifiant());
        assertEquals("Jean Dupont", employe.getNom());
        assertEquals("123 Rue", employe.getAdresse());
        assertEquals("0600000000", employe.getContact());
        assertEquals(1, employe.getNumeroEmploye());
        assertEquals(LocalDate.of(2020, 1, 15), employe.getDateEmbauche());
    }

    @Test
    void obtenirRole_retourneRole() {
        Employe employe = new Employe("E001", "Jean Dupont", "123 Rue", "0600000000", 1, "2020-01-15");

        assertEquals("Employe", employe.obtenirRole());
    }

    @Test
    void setNumeroEmploye_changeNumeroEmploye() {
        Employe employe = new Employe("E001", "Jean Dupont", "123 Rue", "0600000000", 1, "2020-01-15");

        employe.setNumeroEmploye(2);

        assertEquals(2, employe.getNumeroEmploye());
    }

    @Test
    void setDateEmbauche_changeDate() {
        Employe employe = new Employe("E001", "Jean Dupont", "123 Rue", "0600000000", 1, "2020-01-15");

        employe.setDateEmbauche("2021-06-10");

        assertEquals(LocalDate.of(2021, 6, 10), employe.getDateEmbauche());
    }

    @Test
    void getters_retournentBonnesValeurs() {
        Employe employe = new Employe("E001", "Jean Dupont", "123 Rue de Paris", "0600000000", 1, "2020-01-15");

        assertEquals("E001", employe.getIdentifiant());
        assertEquals("Jean Dupont", employe.getNom());
        assertEquals("123 Rue de Paris", employe.getAdresse());
        assertEquals("0600000000", employe.getContact());
        assertEquals(1, employe.getNumeroEmploye());
        assertEquals(LocalDate.of(2020, 1, 15), employe.getDateEmbauche());
    }

    @Test
    void setters_modifientDonnees() {
        Employe employe = new Employe("E001", "Jean", "Adresse", "0600000000", 1, "2020-01-15");

        employe.setIdentifiant("E002");
        employe.setNom("Pierre");
        employe.setAdresse("Nouvelle Adresse");
        employe.setContact("0700000000");

        assertEquals("E002", employe.getIdentifiant());
        assertEquals("Pierre", employe.getNom());
        assertEquals("Nouvelle Adresse", employe.getAdresse());
        assertEquals("0700000000", employe.getContact());
    }
}
