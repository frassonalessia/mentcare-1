package univr.Models;

import univr.Models.Repositories.DiagnosiRepository;
import univr.Models.Repositories.FarmacoRepository;
import univr.Models.Repositories.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader {

    private DiagnosiRepository diagnosiRepository;
    private PazienteRepository pazienteRepository;
    private FarmacoRepository farmacoRepository;

    @Autowired
    public DataLoader(DiagnosiRepository diagnosiRepository, PazienteRepository pazienteRepository, FarmacoRepository farmacoRepository){
        this.diagnosiRepository = diagnosiRepository;
        this.pazienteRepository = pazienteRepository;
        this.farmacoRepository = farmacoRepository;

        LoadPazienti();
        LoadDiagnosi();
        LoadFarmaci();
    }

    private void LoadPazienti(){
            Date data = Calendar.getInstance().getTime();

            pazienteRepository.save(new Paziente("Abc", "Mario", "Rossi",
                    data, "Brescia",
                    "BS", "333", "4444"));
            pazienteRepository.save(new Paziente("CDE", "Anna", "Verdi",
                    data, "Brescia",
                    "BS", "333", "4444"));

    }

    private void LoadDiagnosi(){
        diagnosiRepository.save(new Diagnosi("prova1", "", false,
                Calendar.getInstance().getTime(), 1  , pazienteRepository.findById(1)));

        diagnosiRepository.save(new Diagnosi("prova2", "", true,
                Calendar.getInstance().getTime(), 1  , pazienteRepository.findById(2)));
    }

    private void LoadFarmaci(){
        farmacoRepository.save(new Farmaco("Antiepilettico"));
        farmacoRepository.save(new Farmaco("Antidepressivo"));
        farmacoRepository.save(new Farmaco("Sedativo"));
    }


}
