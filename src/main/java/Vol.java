import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Vol {
    public int numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String Etat;

    public void planifierVol(int numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee){
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




}
