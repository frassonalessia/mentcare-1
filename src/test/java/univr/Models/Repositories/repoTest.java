package univr.Models.Repositories;


import org.hibernate.resource.beans.container.internal.CdiBeanContainerImmediateAccessImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;
import univr.Models.*;
import univr.Models.Repositories.*;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class repoTest {

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



    @Test
    public void testDataLoader(){

        assertEquals(0, pazienteRepository.count());
        assertEquals(0, farmacoRepository.count());
        assertEquals(0, diagnosiRepository.count());

        DataLoader dataLoader = new DataLoader(diagnosiRepository, pazienteRepository, farmacoRepository);

        assert(diagnosiRepository.count()>0);

        assert(pazienteRepository.count()>0);

        assert(farmacoRepository.count() > 0);
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
