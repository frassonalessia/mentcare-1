package univr.Models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PrescrizioneTest {

    private Paziente paz;
    private Farmaco f;
    private Visita v;
    private Prescrizione prescr;
    private Prescrizione prescrNoFarmaco;
    private Date data;


    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

        f = new Farmaco("farmaco1");

        v = new Visita(data, 1, paz);

        prescr = new Prescrizione("Descr1", data, f,v);

        prescrNoFarmaco = new Prescrizione("Descr1", data,v);
    }

    @Test
    public void testSetVisita(){
        Visita v2 = new Visita(data, 5, paz);
        prescr.setVisita(v2);
        assertEquals(v2, prescr.getVisita());
    }

    @Test
    public void testGetVisita() {
        assertEquals(v, prescr.getVisita());
    }

    @Test
    public void testSetFarmaco() {
        Farmaco f2 = new Farmaco("provaFarmaco");
        prescr.setFarmaco(f2);
        assertEquals(f2, prescr.getFarmaco());
    }

    @Test
    public void testGetFarmaco() {
        assertEquals(f, prescr.getFarmaco());
    }

    @Test
    public void testSetData() {
        Date data2 = Calendar.getInstance().getTime();
        prescr.setDataprescrizione(data2);
        assertEquals(data2, prescr.getDataprescrizione());
    }

    @Test
    public void testGetData() {
        assertEquals(data, prescr.getDataprescrizione());
    }

    @Test
    public void testSetDescrizione() {
        prescr.setDescrizione("DescrProva");
        assertEquals("DescrProva", prescr.getDescrizione());
    }

    @Test
    public void testGetDescrizione() {
        assertEquals("Descr1", prescr.getDescrizione());
    }
}
