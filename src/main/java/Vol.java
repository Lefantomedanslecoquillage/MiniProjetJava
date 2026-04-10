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
    Map<Integer, List<String>> vol = new HashMap<>();

    public void planifierVol(int numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee){
        List<String> detailsVol = new ArrayList<>();
        detailsVol.add(origine);
        detailsVol.add(destination);
        detailsVol.add(dateHeureDepart);
        detailsVol.add(dateHeureArrivee);
        vol.put(numeroVol, detailsVol);

    }

    public void annulerVol(int numeroVol){
        Map<Integer, List<String>> vol = new HashMap<>();
        vol.remove(numeroVol);
    }

    public void obtenirInfosVol(int numeroVol){
        Map<Integer, List<String>> vol = new HashMap<>();
        List<String> detailsVol = vol.get(numeroVol);
        if(detailsVol != null){
            System.out.println("Le vol numéro " + numeroVol + " part de " + detailsVol.get(0) + " à destination de " + detailsVol.get(1) + ". Il décolle à " + detailsVol.get(2) + " et atterrit à " + detailsVol.get(3) + ".");
        } else {
            System.out.println("Le vol numéro " + numeroVol + " n'existe pas.");
        }
    }



}
