package univr.Models;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DiagnosiTest {

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
    public void testGetData() {
        assertEquals(data, d.getData());
    }


    @Test
    public void testGetPaziente() {
        assertEquals(paz, d.getPaziente());
    }


    @Test
    public void testGetIdMedico() {
        assertEquals(1, d.getIdMedico());
    }


    @Test
    public void testIsPericoloso() {
        assertFalse(d.isPericoloso());
    }


    @Test
    public void testGetDescrizione() {
        assertEquals("", d.getDescrizione());
    }


    @Test
    public void testGetNome() {
        assertEquals("prova1", d.getNome());
    }


    @Test
    public void testSetData() {
        Date data2 = Calendar.getInstance().getTime();
        d.setData(data2);
        assertEquals(data2, d.getData());
    }


    @Test
    public void testSetPaziente() {
        Paziente p2 = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");
        d.setPaziente(p2);
        assertEquals(p2, d.getPaziente());
    }


    @Test
    public void testSetIdMedico() {
        d.setIdMedico(5);
        assertEquals(5, d.getIdMedico());
    }


    @Test
    public void testSetPericoloso() {
        d.setPericoloso(true);
        assertTrue(d.isPericoloso());
    }


    @Test
    public void testSetDescrizione() {
        d.setDescrizione("descr");
        assertEquals("descr", d.getDescrizione());
    }


    @Test
    public void testSetNome() {
        d.setNome("provaTest");
        assertEquals("provaTest", d.getNome());
    }

}
