import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Aeroport aeroportParis = new Aeroport("CDG", "Paris", "Aéroport Charles de Gaulle");
        Aeroport aeroportNewYork = new Aeroport("JFK", "New York", "Aéroport John F. Kennedy");

        Avion avionA320 = new Avion(12345, "Airbus A320", 180);
        Pilote pilote = new Pilote("P001", "Marc Lefevre", "10 Av. des Champs", "0600000000", 1001, "2024-01-10", "A320", 2500);
        PersonnelCabine membreCabine = new PersonnelCabine("PC001", "Alice Dupont", "123 Rue Principale", "0600111222", 23454, "2025-08-10");

        Vol volParisNY = new Vol("AF001", aeroportParis, aeroportNewYork,
                LocalDateTime.of(2026, 9, 20, 10, 0),
                LocalDateTime.of(2026, 9, 20, 14, 0));
        volParisNY.planifierVol();
        volParisNY.affecterPilote(pilote);
        volParisNY.affecterAvion(avionA320);
        volParisNY.ajouterPersonnelCabine(membreCabine);

        Passager passager = new Passager("PA001", "Julie Martin", "45 Rue du Parc", "0600222333", "P1234567");
        Reservation reservation = passager.reserverVol(volParisNY);

        System.out.println("Informations du passager : " + passager.ObtenirInfos());
        System.out.println("Réservation confirmée : " + reservation);
        System.out.println("Vol réservé : " + volParisNY);
        System.out.println("Avion disponible le 2026-09-20 ? " + avionA320.verifierDisponibilite("2026-09-20"));
        System.out.println("Passagers sur le vol : " + volParisNY.ListingPassager());
    }
}
