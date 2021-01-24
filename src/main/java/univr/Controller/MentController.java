package univr.Controller;

import univr.Models.*;
import univr.Models.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class MentController {

    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private DiagnosiRepository diagnosiRepository;
    @Autowired
    private FarmacoRepository farmacoRepository;
    @Autowired
    private VisitaRepository visitaRepository;
    @Autowired
    private PrescrizioneRepository prescrizioneRepository;


    @RequestMapping("/")
    public String index() {

        return "redirect:/homeMedico";
    }

    private Visita vis;
    private Paziente paz;

    @RequestMapping("/homeMedico")
    public String homeMedico(Model model) {

        List<Paziente> pazienti = new LinkedList<>();

        for (Paziente p : pazienteRepository.findAll()) {
            pazienti.add(p);
        }

        List<Diagnosi> d = new LinkedList<>();
        for (Diagnosi diagnosi : diagnosiRepository.findAll()){
            d.add(diagnosi);
        }
        model.addAttribute("diagnosi", d);

        model.addAttribute("pazienti", pazienti);

        return "homeMedico";
    }

    @RequestMapping("/cartellaPaziente")
    public String cartella(
            @RequestParam(name = "id", required = true) long id,
            Model model
    ) {
        Paziente p = pazienteRepository.findById(id);
        model.addAttribute("selectedPaziente", p);

        ArrayList<Visita> visite = new ArrayList<>();

        for (Visita v : visitaRepository.findByPaziente(p)){
            visite.add(v);
        }


        Collections.reverse(visite);

        model.addAttribute("visitePaziente", visite);

        return "cartellaPaziente";
    }


    @RequestMapping("/nuovaDiagnosi")
    public String diagnosi(
            @RequestParam(name = "id", required = true) long id,
            @RequestParam(name= "error", required = false) String errore,
            Model model
    ) {
        String messaggioErrore;
        if(errore == null){
            messaggioErrore = "";
        } else {
            messaggioErrore = "Inserire nome diagnosi";
        }

        model.addAttribute("erroreDiagnosi", messaggioErrore);
        Paziente p = pazienteRepository.findById(id);
        model.addAttribute("selectedPaziente", p);

        return "nuovaDiagnosi";
    }

    @RequestMapping("/aggiuntaDiagnosi")
    public String newdiagnosi(@RequestParam(name = "id", required = true) long idPaziente,
                              @RequestParam(name = "nomediagnosi", required = true) String diagnosi,
                              @RequestParam(name = "note") String descrizione,
                              @RequestParam(name = "pericolo") String pericolo,
                              Model model
    ){


        if(diagnosi.equals(""))
        {
            return "redirect:nuovaDiagnosi?id="+idPaziente+"&error=Yes";
        }

        Date data=java.util.Calendar.getInstance().getTime();

        boolean pericoloso = false;
            if(pericolo.equals("No")){
                pericoloso = false;
            } else {
                pericoloso = true;
            }

            Paziente p = pazienteRepository.findById(idPaziente);
            Diagnosi d;
            d = new Diagnosi(diagnosi, descrizione, pericoloso, data, 1 , p );
            diagnosiRepository.save(d);


            return "redirect:cartellaPaziente?id="+idPaziente;
    }


    @RequestMapping("/nuovaVisita")
    public String visita(
            @RequestParam(name = "id", required = true) long id,
            Model model
    ) {
        Paziente p = pazienteRepository.findById(id);
        model.addAttribute("selectedPaziente", p);

        return "nuovaVisita";
    }

    @RequestMapping("/addVisita")
    public String addVisita(
            @RequestParam(name = "id", required = true) long id,
            @RequestParam(name = "note", required = true) String note,
            Model model
    ) {

        Paziente p = pazienteRepository.findById(id);
        Visita vis = new Visita(java.util.Calendar.getInstance().getTime(), 1, p);
        vis.setReport(note);
        visitaRepository.save(vis);

        return "redirect:schedaVisita?idVisita="+vis.getId()+"&aggiunta=yes";
    }


    @RequestMapping("/nuovaPrescrizione")
    public String prescrizione(
            @RequestParam(name = "idVisita", required = true) long idVisita,
            @RequestParam(name="error", required = false) String errore,
            Model model
    ) {

        String messaggioErrore;
        if(errore == null){
            messaggioErrore = "";
        } else {
            messaggioErrore = " Compilare il campo note/frequenza";
        }
        model.addAttribute("MessagePrescrizione",
                messaggioErrore);

        List<Farmaco> farmaci = new LinkedList<>();
        for (Farmaco f : farmacoRepository.findAll()){
            farmaci.add(f);
        }

        model.addAttribute("farmaci", farmaci);
        model.addAttribute("idVisita", idVisita);
        model.addAttribute("paziente", visitaRepository.findById(idVisita).getPaziente());

        return "nuovaPrescrizione";
    }

    @RequestMapping("/addPrescrizione")
    public String addPrescrizione(
            @RequestParam(name = "id", required = true) long idVisita,
            @RequestParam(name = "farmaco", required = true) long idFarmaco,
            @RequestParam(name = "descrizione", required = true) String note,
            Model model
    ) {


        if(note.equals("")){
            return "redirect:nuovaPrescrizione?idVisita="+idVisita+"&error=Yes";

        } else {
            Prescrizione prescrizione;

            if(idFarmaco >= 0)
                prescrizione = new Prescrizione(note, Calendar.getInstance().getTime(),
                        farmacoRepository.findById(idFarmaco), visitaRepository.findById(idVisita));
            else
                prescrizione = new Prescrizione(note, Calendar.getInstance().getTime(),
                        visitaRepository.findById(idVisita));

            prescrizioneRepository.save(prescrizione);

            return "redirect:schedaVisita?idVisita="+idVisita+"&aggiunta=yes";
            //return schedaVisita(idVisita, model);
        }

    }

    @RequestMapping("/schedaVisita")
    public String schedaVisita(
        @RequestParam(name = "idVisita", required = true) long idVisita,
        @RequestParam(name = "aggiunta", required = false) String aggiuntaPrescAbilitata,
        Model model
    ) {
        Visita visita = visitaRepository.findById(idVisita);
        List<Prescrizione> prescrizioniVisita = new ArrayList<>();

        for(Prescrizione prescr : prescrizioneRepository.findByVisita(visita)){
            if(prescr.getFarmaco() != null)
                prescrizioniVisita.add(prescr);
        }

        model.addAttribute("paziente", visita.getPaziente());
        model.addAttribute("visita", visita);
        model.addAttribute("prescrizioni", prescrizioniVisita);

        if(aggiuntaPrescAbilitata != null && aggiuntaPrescAbilitata.equals("yes")){
            model.addAttribute("aggiuntaAbilitata", true);
        } else {
            model.addAttribute("aggiuntaAbilitata", false);
        }

        return "schedaVisita";
    }

    @RequestMapping("/reportVisita")
    public String reportVisita(
            @RequestParam(name = "idVisita", required = true) long idVisita,
            Model model
    ) {
        return "redirect:schedaVisita?idVisita="+idVisita+"&aggiunta=no";
    }

    @RequestMapping("/paginaSegnalazione")
    public String segnalazione(){
        return "paginaSegnalazione";
    }
}
