import java.util.ArrayList;
import java.util.List;

public class PersonnelCabine extends Employe{
    private String qualification;
    private List<Vol> volsaffectes = new ArrayList<>();

    public PersonnelCabine(int identifiant, String nom, String adresse, int contact, int numeroEmploye, String dateEmbauche, String qualification){
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    @Override
    public String obtenirRole(){
        return "Personnel de cabine";
    }

    public void affecterVol(Vol vol){
        volsaffectes.add(vol);
    }
    public List<Vol> obtenirVol() {
        return volsaffectes;
    }

}
