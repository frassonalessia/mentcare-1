package univr.Models.Repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import univr.Models.Diagnosi;
import univr.Models.Paziente;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PazienteRepoTest {

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
    private Date data;

    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

    }


    @Test
    public void test_AddPaziente(){

        pazienteRepository.save(paz);
        assertEquals("Mario", pazienteRepository.findById(paz.getId()).getNome());

    }

    @Test
    public void test_deletePaziente(){
        pazienteRepository.save(paz);
        pazienteRepository.delete(paz);
        Paziente pazfound = pazienteRepository.findById(paz.getId());
        assertNull(pazfound);
    }

    @Test
    public void test_DeleteAllPazienti(){
        pazienteRepository.save(paz);
        assert (pazienteRepository.count() > 0);
        pazienteRepository.deleteAll();
        assertEquals(0,pazienteRepository.count() );
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
