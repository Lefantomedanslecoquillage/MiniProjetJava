import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonnelCabine extends Employe{
    private String qualification;
    private List<Vol> volsaffectes = new ArrayList<>();

    public PersonnelCabine(String identifiant, String nom, String adresse, String contact, int numeroEmploye, String dateEmbauche){
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = "Personnel de cabine";
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
