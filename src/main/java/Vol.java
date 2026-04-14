import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.time.LocalDateTime;

public class Vol {
    public int numeroVol;
    private String origine;
    private String destination;
    private LocalDateTime dateHeureDepart;
    private LocalDateTime dateHeureArrivee;
    private String Etat;

    private List<Passager> passagers = new ArrayList<>();

    public Vol(int numeroVol, String origine, String destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee){
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = "Planifié";
    }

    public void planifierVol(int numeroVol, String origine, String destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee){
       this.numeroVol = numeroVol;
       this.origine = origine;
       this.destination = destination;
       this.dateHeureDepart = dateHeureDepart;
       this.dateHeureArrivee = dateHeureArrivee;
       this.Etat = "Vol";

    }

    public void annulerVol(int numeroVol){
        this.numeroVol = numeroVol;
        this.Etat = "Annulé";
    }


    public void ajouterPassager(Passager passager) {this.passagers.add(passager);}
}
