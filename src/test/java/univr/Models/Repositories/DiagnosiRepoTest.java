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
public class DiagnosiRepoTest {

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
    private Diagnosi d;
    private Date data;

    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

        d = new Diagnosi("prova1", "", false,
                data, 1  , paz);

    }

    @Test
    public void test_addDiagnosi(){

        pazienteRepository.save(paz);
        diagnosiRepository.save(d);

        Diagnosi diagnosi = diagnosiRepository.findById(d.getId());
        assertEquals("prova1", diagnosi.getNome());

    }

    @Test
    public void test_deleteDiagnosi(){

        pazienteRepository.save(paz);
        diagnosiRepository.save(d);
        diagnosiRepository.delete(d);
        assertNull(diagnosiRepository.findById(d.getId()));
    }

    @Test
    public void test_DeleteAllDiagnosi(){
        pazienteRepository.save(paz);
        diagnosiRepository.save(d);
        assert(diagnosiRepository.count()>0);
        diagnosiRepository.deleteAll();
        assertEquals(0,diagnosiRepository.count());

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
