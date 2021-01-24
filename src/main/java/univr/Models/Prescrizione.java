package univr.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prescrizione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descrizione;
    private Date dataprescrizione;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Farmaco.class)
    @JoinColumn(name = "farmaco_id")
    private Farmaco farmaco;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Visita.class)
    @JoinColumn(name = "visita_id")
    private Visita visita;

    protected Prescrizione() {}

    public Prescrizione(String descrizione, Date dataprescrizione,  Visita visita){
        this.descrizione = descrizione;
        this.dataprescrizione = dataprescrizione;
        this.visita = visita;
    }

    public Prescrizione(String descrizione, Date dataprescrizione, Farmaco farmaco, Visita visita){
        this.descrizione = descrizione;
        this.dataprescrizione = dataprescrizione;
        this.farmaco = farmaco;
        this.visita = visita;
    }

    public long getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataprescrizione() {
        return dataprescrizione;
    }

    public void setDataprescrizione(Date dataprescrizione) {
        this.dataprescrizione = dataprescrizione;
    }

    public Farmaco getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(Farmaco farmaco) {
        this.farmaco = farmaco;
    }


    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }
}
