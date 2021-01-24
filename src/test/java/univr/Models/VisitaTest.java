package univr.Models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitaTest {

    private Paziente paz;
    private Diagnosi d;
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


        d = new Diagnosi("prova1", "", false,
                data, 1  , paz);

        f = new Farmaco("farmaco1");

        v = new Visita(data, 1, paz);

        prescr = new Prescrizione("Descr1", data, f,v);

        prescrNoFarmaco = new Prescrizione("Descr1", data,v);
    }

    @Test
    public void testSetPrescrizioni() {
        v.setPrescrizioni(new ArrayList<>());
        assertEquals(0, v.getPrescrizioni().size());
    }

    @Test
    public void testAddPrescrizione() {
        int size = v.getPrescrizioni().size();
        v.addPrescrizione(prescr);
        assertEquals(size + 1, v.getPrescrizioni().size());
    }

    @Test
    public void testSetPaziente() {
        Paziente p2 = new Paziente("CDE", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");
        v.setPaziente(p2);
        assertEquals(p2, v.getPaziente());
        assertNotEquals(paz, v.getPaziente());
    }

    @Test
    public void testGetPaziente() {
        assertEquals(paz,v.getPaziente());
    }

    @Test
    public void testSetReport() {
        v.setReport("Prova");
        assertEquals("Prova", v.getReport());
    }

    @Test
    public void testGetReport() {
        assertNull(v.getReport());
    }

    @Test
    public void testSetDataVisita() {
        Date d2 = Calendar.getInstance().getTime();
        v.setDataVisita(d2);
        assertEquals(d2, v.getDataVisita());
    }

    @Test
    public void testGetDataVisita() {
        assertEquals(data, v.getDataVisita());
    }

    @Test
    public void testSetIdMedico() {
        v.setIdMedico(5);
        assertEquals(5, v.getIdMedico());
    }

    @Test
    public void testGetIdmedico() {
        assertEquals(1,v.getIdMedico());
    }

}
