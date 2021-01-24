package univr.Models;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class FarmacoTest {

    private Farmaco f;

    @Before
    public void init(){

        f = new Farmaco("farmaco1");

    }

    @Test
    public void testGetNome(){
        assertEquals("farmaco1", f.getNome());
    }

    @Test
    public void testSetNome(){
            f.setNome("farmacoProva");
            assertEquals("farmacoProva", f.getNome());
    }

}
