package univr.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date dataVisita;
    private long idMedico;
    private String report;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Paziente.class)
    @JoinColumn(name = "paziente_id")
    private Paziente paziente;

    @OneToMany(mappedBy = "visita", targetEntity=Prescrizione.class)
    private List<Prescrizione> prescrizioni = new ArrayList<>();

    protected Visita() {}

    public Visita (Date dataVisita, long idMedico, Paziente paziente){
        this.dataVisita = dataVisita;
        this.idMedico = idMedico;
        this.paziente = paziente;
    }


    public long getId() {
        return id;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public List<Prescrizione> getPrescrizioni() {
        return prescrizioni;
    }

    public void addPrescrizione(Prescrizione prescrizione){
       prescrizioni.add(prescrizione);
    }

    public void setPrescrizioni(List<Prescrizione> prescrizioni) {
        this.prescrizioni = prescrizioni;
    }
}
