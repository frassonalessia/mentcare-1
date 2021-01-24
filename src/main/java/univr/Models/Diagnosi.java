package univr.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Diagnosi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String descrizione;
    private boolean pericoloso;
    private Date data;
    private long idMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paziente_id")
    private Paziente paziente;

    protected Diagnosi(){}

    public Diagnosi(String nome, String descrizione, boolean pericoloso, Date inizio, long idMedico, Paziente paziente){
        this.nome = nome;
        this.descrizione = descrizione;
        this.pericoloso = pericoloso;
        this.data = inizio;
        this.idMedico = idMedico;
        this.paziente = paziente;
    }


    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isPericoloso() {
        return pericoloso;
    }

    public void setPericoloso(boolean pericoloso) {
        this.pericoloso = pericoloso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date inizio) {
        this.data = inizio;
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
}
