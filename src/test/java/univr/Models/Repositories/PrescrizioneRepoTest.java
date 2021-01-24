package univr.Models.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.Models.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrescrizioneRepoTest {

    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private FarmacoRepository farmacoRepository;
    @Autowired
    private PrescrizioneRepository prescrizioneRepository;
    @Autowired
    private VisitaRepository visitaRepository;

    private Paziente paz;
    private Farmaco f;
    private Visita v;
    private Prescrizione prescr;
    private Date data;


    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

        f = new Farmaco("farmaco1");

        v = new Visita(data, 1, paz);

        prescr = new Prescrizione("Descr1", data, f,v);

    }


    @Test
    public void test_addPrescrizione(){

        pazienteRepository.save(paz);
        visitaRepository.save(v);
        farmacoRepository.save(f);
        prescrizioneRepository.save(prescr);
        assertEquals("Descr1", prescrizioneRepository.findById(prescr.getId()).getDescrizione());
    }

    @Test
    public void test_deletePrescrizione(){
        pazienteRepository.save(paz);
        visitaRepository.save(v);
        farmacoRepository.save(f);
        prescrizioneRepository.save(prescr);
        prescrizioneRepository.delete(prescr);
        assertNull(prescrizioneRepository.findById(prescr.getId()));
    }

    @Test
    public void test_DeleteAllPrescrizioni(){
        pazienteRepository.save(paz);
        visitaRepository.save(v);
        farmacoRepository.save(f);
        prescrizioneRepository.save(prescr);
        assert (pazienteRepository.count() > 0);

        prescrizioneRepository.deleteAll();
        assert (prescrizioneRepository.count() == 0);
    }


    @After
    public void clearAllRepo(){
        prescrizioneRepository.deleteAll();
        farmacoRepository.deleteAll();
        visitaRepository.deleteAll();
        pazienteRepository.deleteAll();
    }

}
