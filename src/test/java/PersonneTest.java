import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void constructeur_creePersonneAvecDonnees() {
        Personne personne = new Personne("P001", "Jean Dupont", "123 Rue de Paris", "0600000000");

        assertEquals("P001", personne.getIdentifiant());
        assertEquals("Jean Dupont", personne.getNom());
        assertEquals("123 Rue de Paris", personne.getAdresse());
        assertEquals("0600000000", personne.getContact());
    }

    @Test
    void ObtenirInfos_retourneInformationsFormatees() {
        Personne personne = new Personne("P001", "Jean Dupont", "123 Rue", "0600000000");

        String infos = personne.ObtenirInfos();

        assertTrue(infos.contains("P001"));
        assertTrue(infos.contains("Jean Dupont"));
        assertTrue(infos.contains("123 Rue"));
        assertTrue(infos.contains("0600000000"));
    }

    @Test
    void toString_retourneLesMemesInfos() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        String str = personne.toString();

        assertTrue(str.contains("P001"));
        assertTrue(str.contains("Jean"));
    }

    @Test
    void getIdentifiant_retourneLIdentifiant() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        assertEquals("P001", personne.getIdentifiant());
    }

    @Test
    void getNom_retourneLenom() {
        Personne personne = new Personne("P001", "Jean Dupont", "Adresse", "0600000000");

        assertEquals("Jean Dupont", personne.getNom());
    }

    @Test
    void getAdresse_retourneLadresse() {
        Personne personne = new Personne("P001", "Jean", "123 Rue de Paris", "0600000000");

        assertEquals("123 Rue de Paris", personne.getAdresse());
    }

    @Test
    void getContact_retourneLecontact() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        assertEquals("0600000000", personne.getContact());
    }

    @Test
    void setIdentifiant_changeIdentifiant() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        personne.setIdentifiant("P002");

        assertEquals("P002", personne.getIdentifiant());
    }

    @Test
    void setNom_changeNom() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        personne.setNom("Pierre");

        assertEquals("Pierre", personne.getNom());
    }

    @Test
    void setAdresse_changeAdresse() {
        Personne personne = new Personne("P001", "Jean", "123 Rue", "0600000000");

        personne.setAdresse("456 Avenue");

        assertEquals("456 Avenue", personne.getAdresse());
    }

    @Test
    void setContact_changeContact() {
        Personne personne = new Personne("P001", "Jean", "Adresse", "0600000000");

        personne.setContact("0700000000");

        assertEquals("0700000000", personne.getContact());
    }

    @Test
    void getters_retournentBonnesValeurs() {
        Personne personne = new Personne("P123", "Alice Martin", "42 Boulevard St-Germain", "0702030405");

        assertEquals("P123", personne.getIdentifiant());
        assertEquals("Alice Martin", personne.getNom());
        assertEquals("42 Boulevard St-Germain", personne.getAdresse());
        assertEquals("0702030405", personne.getContact());
    }

    @Test
    void setters_modifientToutesDonnees() {
        Personne personne = new Personne("P001", "Jean", "Adresse1", "0600000000");

        personne.setIdentifiant("P999");
        personne.setNom("Charles");
        personne.setAdresse("Adresse2");
        personne.setContact("0799999999");

        assertEquals("P999", personne.getIdentifiant());
        assertEquals("Charles", personne.getNom());
        assertEquals("Adresse2", personne.getAdresse());
        assertEquals("0799999999", personne.getContact());
    }

    @Test
    void ObtenirInfos_ContientAllInformations() {
        String id = "EMP456";
        String nom = "Sophie Laurent";
        String adresse = "789 Rue de la Paix";
        String contact = "0701020304";
        
        Personne personne = new Personne(id, nom, adresse, contact);

        String infos = personne.ObtenirInfos();

        assertTrue(infos.contains("Identifiant: " + id));
        assertTrue(infos.contains("Nom: " + nom));
        assertTrue(infos.contains("Adresse: " + adresse));
        assertTrue(infos.contains("Contact: " + contact));
    }
}
