import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    /**
     * Sauvegarde une liste de vols dans un fichier CSV
     * Format: numeroVol,origine,destination,dateHeureDepart,dateHeureArrivee,etat,avion,pilote
     */
    public static void sauvegarderVols(List<Vol> vols, String cheminFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // En-tête
            writer.write("numeroVol,origine,destination,dateHeureDepart,dateHeureArrivee,etat,avion,pilote");
            writer.newLine();

            // Données
            for (Vol vol : vols) {
                StringBuilder ligne = new StringBuilder();
                ligne.append(vol.getNumeroVol()).append(",");
                ligne.append(vol.getOrigine() != null ? vol.getOrigine().getNom() : "").append(",");
                ligne.append(vol.getDestination() != null ? vol.getDestination().getNom() : "").append(",");
                ligne.append(vol.getDateHeureDepart()).append(",");
                ligne.append(vol.getDateHeureArrivee()).append(",");
                ligne.append(vol.getEtat()).append(",");
                ligne.append(vol.getAvion() != null ? vol.getAvion().getImmatriculation() : "").append(",");
                ligne.append(vol.getPilote() != null ? vol.getPilote().getNom() : "");

                writer.write(ligne.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Sauvegarde une liste de passagers dans un fichier CSV
     * Format: identifiant,nom,adresse,contact,passeport,nombreReservations
     */
    public static void sauvegarderPassagers(List<Passager> passagers, String cheminFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // En-tête
            writer.write("identifiant,nom,adresse,contact,passeport,nombreReservations");
            writer.newLine();

            // Données
            for (Passager passager : passagers) {
                StringBuilder ligne = new StringBuilder();
                ligne.append(passager.getIdentifiant()).append(",");
                ligne.append(passager.getNom()).append(",");
                ligne.append(passager.getAdresse()).append(",");
                ligne.append(passager.getContact()).append(",");
                ligne.append(passager.getPasseport()).append(",");
                ligne.append(passager.obtenirReservations().size());

                writer.write(ligne.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Sauvegarde une liste de réservations dans un fichier CSV
     * Format: numeroReservation,dateReservation,statut,passager,vol
     */
    public static void sauvegarderReservations(List<Reservation> reservations, String cheminFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // En-tête
            writer.write("numeroReservation,dateReservation,statut,passager,vol");
            writer.newLine();

            // Données
            for (Reservation reservation : reservations) {
                StringBuilder ligne = new StringBuilder();
                ligne.append(reservation.getNumeroReservation()).append(",");
                ligne.append(reservation.getDateReservation()).append(",");
                ligne.append(reservation.getStatut()).append(",");
                ligne.append(reservation.getPassager() != null ? reservation.getPassager().getNom() : "").append(",");
                ligne.append(reservation.getVol() != null ? reservation.getVol().getNumeroVol() : "");

                writer.write(ligne.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Sauvegarde une liste d'avions dans un fichier CSV
     * Format: immatriculation,modele,capacite,nombreVols
     */
    public static void sauvegarderAvions(List<Avion> avions, String cheminFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // En-tête
            writer.write("immatriculation,modele,capacite,nombreVols");
            writer.newLine();

            // Données
            for (Avion avion : avions) {
                StringBuilder ligne = new StringBuilder();
                ligne.append(avion.getImmatriculation()).append(",");
                ligne.append(avion.getModele()).append(",");
                ligne.append(avion.getCapacite()).append(",");
                ligne.append(avion.getVolsAffectes().size());

                writer.write(ligne.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Sauvegarde une liste d'aéroports dans un fichier CSV
     * Format: nom,ville,description,nombreVolsDepart,nombreVolsArrivee
     */
    public static void sauvegarderAeroports(List<Aeroport> aeroports, String cheminFichier) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // En-tête
            writer.write("nom,ville,description,nombreVolsDepart,nombreVolsArrivee");
            writer.newLine();

            // Données
            for (Aeroport aeroport : aeroports) {
                StringBuilder ligne = new StringBuilder();
                ligne.append(aeroport.getNom()).append(",");
                ligne.append(aeroport.getVille()).append(",");
                ligne.append(aeroport.getDescription()).append(",");
                ligne.append(aeroport.getVolsDepart().size()).append(",");
                ligne.append(aeroport.getVolsArrivee().size());

                writer.write(ligne.toString());
                writer.newLine();
            }
        }
    }

}
