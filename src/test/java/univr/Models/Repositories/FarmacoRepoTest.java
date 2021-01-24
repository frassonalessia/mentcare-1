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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmacoRepoTest {

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

    private Farmaco f;

    @Before
    public void init(){
        f = new Farmaco("farmaco1");
    }


    @Test
    public void test_addFarmaco(){
        farmacoRepository.save(f);
        assertEquals("farmaco1", farmacoRepository.findById(f.getId()).getNome());
    }

    @Test
    public void test_deleteFarmaco(){
        farmacoRepository.save(f);
        farmacoRepository.delete(f);
        assertNull(farmacoRepository.findById(f.getId()));
    }

    @Test
    public void test_deleteAllFarmaco(){
        farmacoRepository.save(f);
        farmacoRepository.save(new Farmaco("Prova"));
        assert(farmacoRepository.count()>0);
        farmacoRepository.deleteAll();
        assertEquals(0,farmacoRepository.count());
    }


    @After
    public void clearAllRepo(){
        prescrizioneRepository.deleteAll();
        farmacoRepository.deleteAll();
        visitaRepository.deleteAll();
        diagnosiRepository.deleteAll();
        pazienteRepository.deleteAll();
    }



}
