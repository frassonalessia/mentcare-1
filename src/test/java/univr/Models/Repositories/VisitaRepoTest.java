package univr.Models.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.Models.Farmaco;
import univr.Models.Paziente;
import univr.Models.Prescrizione;
import univr.Models.Visita;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitaRepoTest {

    @Autowired
    private DiagnosiRepository diagnosiRepository;
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private FarmacoRepository farmacoRepository;
    @Autowired
    private PrescrizioneRepository prescrizioneRepository;
    @Autowired
    private VisitaRepository visitaRepository;

    private Paziente paz;
    private Visita v;
    private Date data;


    @After
    public void clearAllRepo(){
        prescrizioneRepository.deleteAll();
        farmacoRepository.deleteAll();
        visitaRepository.deleteAll();
        diagnosiRepository.deleteAll();
        pazienteRepository.deleteAll();
    }

    @Test
    public void test_addVisita(){

        pazienteRepository.save(paz);
        visitaRepository.save(v);
        assertEquals(v.getId(), visitaRepository.findById(v.getId()).getId());

    }

    @Test
    public void test_deleteVisita(){

        pazienteRepository.save(paz);
        visitaRepository.save(v);
        visitaRepository.delete(v);
        assertNull(visitaRepository.findById(v.getId()));
    }

    @Test
    public void test_deleteAllVisite(){
        pazienteRepository.save(paz);
        visitaRepository.save(v);
        assert(visitaRepository.count()>0);
        visitaRepository.deleteAll();
        assert(visitaRepository.count() == 0);
    }


    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

        v = new Visita(data, 1, paz);

    }

}
