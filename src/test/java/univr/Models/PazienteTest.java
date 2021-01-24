package univr.Models;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PazienteTest {
    private Paziente paz;
    private Date data;
    private Visita v;
    private Diagnosi d;

    @Before
    public void init(){
        data = Calendar.getInstance().getTime();

        paz = new Paziente("Abc", "Mario", "Rossi",
                data, "Brescia","BS", "333", "4444");

        d = new Diagnosi("prova1", "", false,
                data, 1  , paz);

        v = new Visita(data, 1, paz);

    }

    @Test
    public void testGetCodiceFiscale(){
        assertEquals(
                "Abc", paz.getCodiceFiscale());
    }

    @Test
    public void testSetCodiceFiscale() {
        paz.setCodiceFiscale("AAA");
        assertEquals("AAA", paz.getCodiceFiscale());
    }

    @Test
    public void testGetNome(){

        assertEquals("Mario", paz.getNome());
    }

    @Test
    public void TestSetNome() {
        paz.setNome("AAA");
        assertEquals("AAA", paz.getNome());
    }

    @Test
    public void testGetCognome(){

        assertEquals("Rossi", paz.getCognome());
    }

    @Test
    public void TestSetCognome() {
        paz.setNome("Bianchi");
        assertEquals("Bianchi", paz.getNome());
    }


    @Test
    public void testSetVisita() {
        paz.setVisita(new ArrayList<>());
        assertEquals(0,paz.getVisita().size());
    }

    @Test
    public void testAddVisita() {
        int size = paz.getVisita().size();
        paz.addVisita(v);
        assertEquals(size + 1,paz.getVisita().size());
    }

    @Test
    public void testGetVisita(){
        paz.setVisita(new ArrayList<>());

        ArrayList<Visita> visite = new ArrayList<>();
        visite.add(v);
        visite.add(new Visita(data, 2, paz));
        paz.setVisita(visite);

        assertEquals(visite, paz.getVisita());
    }

    @Test
    public void testSetDiagnosi() {
        ArrayList<Diagnosi> diagnosiPaz = new ArrayList<>();
        paz.setDiagnosi(diagnosiPaz);
        assertEquals(0,paz.getDiagnosi().size());

        diagnosiPaz.add(d);
        paz.setDiagnosi(diagnosiPaz);
        assertEquals(diagnosiPaz, paz.getDiagnosi());

    }

    @Test
    public void testAddDiagnosi() {
        int size = paz.getDiagnosi().size();
        paz.addDiagnosi(d);
        assertEquals(size + 1 ,paz.getDiagnosi().size());
    }

    @Test
    public void testGetDiagnosi(){
        paz.setDiagnosi(new ArrayList<>());

        ArrayList<Diagnosi> diagnosiPaz = new ArrayList<>();
        diagnosiPaz.add(d);
        diagnosiPaz.add(new Diagnosi("d2","--", false, data, 2, paz));

        paz.setDiagnosi(diagnosiPaz);
        assertEquals(diagnosiPaz, paz.getDiagnosi());
    }

    @Test
    public void testGetTelefonoParente(){
        assertEquals("4444", paz.getTelefonoParente());
    }

    @Test
    public void testSetTelefonoParente() {

        paz.setTelefonoParente("111");
        assertEquals("111", paz.getTelefonoParente());
    }


    @Test
    public void testGetTelefono(){
        assertEquals("333", paz.getTelefono());
    }


    @Test
    public void testSetTelefono() {

        paz.setTelefono("111");
        assertEquals("111", paz.getTelefono());
    }

    @Test
    public void testSetProvinciaNascita() {
        paz.setProvinciaNascita("AAA");
        assertEquals("AAA", paz.getProvinciaNascita());
    }

    @Test
    public void testGetProvinciaNascita() {
        assertEquals("BS", paz.getProvinciaNascita());
    }

    @Test
    public void testSetLuogoNascita() {
        paz.setLuogoNascita("AAA");
        assertEquals("AAA", paz.getLuogoNascita());
    }

    @Test
    public void testGetLuogoNascita(){
        assertEquals("Brescia", paz.getLuogoNascita());
    }

    @Test
    public void testSetDataNascita() {
        Date data2 = Calendar.getInstance().getTime();
        paz.setDataNascita(data2);
        assertEquals(data2, paz.getDataNascita());
    }

    @Test
    public void getDataNascita(){
        assertEquals(data, paz.getDataNascita());
    }




}
