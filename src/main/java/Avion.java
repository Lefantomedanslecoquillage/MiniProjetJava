import java.util.HashMap;
import java.util.Map;

public class Avion {
    private int immatriculation;
    private String modele;
    private int capacite;

    public void affecterVol(int immatriculation, int numeroVol){
        Vol vol = new Vol();
        this.immatriculation = immatriculation;
        vol.numeroVol = numeroVol;
    }

    public void verifierDisponibilite(int immatriculation, int numeroVol){
        Vol vol = new Vol();
        this.immatriculation = immatriculation;
        vol.numeroVol = numeroVol;
    }
}
