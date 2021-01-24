package univr.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Paziente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String codiceFiscale;

    private String nome;
    private String cognome;
    private Date dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
    private String telefono;
    private String telefonoParente;

    @OneToMany(mappedBy = "paziente")
    private List<Diagnosi> diagnosi = new ArrayList<Diagnosi>();


    @OneToMany(mappedBy = "paziente",targetEntity=Visita.class)
    private List<Visita> visita = new ArrayList<Visita>();


    protected Paziente(){}

    public Paziente(String codiceFiscale, String nome,
                    String cognome, Date dataNascita,
                    String luogoNascita,
                    String provinciaNascita,
                    String telefono,
                    String telefonoParente){
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.provinciaNascita = provinciaNascita;
        this.telefono = telefono;
        this.telefonoParente = telefonoParente;
    }

    public String getCodiceFiscale() { return this.codiceFiscale;}
    public String getNome() {return this.nome;}
    public String getCognome() {return this.cognome;}
    public Date getDataNascita() {return this.dataNascita;}
    public String getLuogoNascita() { return this.luogoNascita;}
    public String getProvinciaNascita() {return this.provinciaNascita;}
    public String getTelefono() { return this.telefono;}
    public String getTelefonoParente() {return this.telefonoParente;}

    public void setCodiceFiscale(String codiceFiscale){ this.codiceFiscale = codiceFiscale;}
    public void setNome(String nome) { this.nome = nome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public void setDataNascita( Date dataNascita){ this.dataNascita = dataNascita;}
    public void setLuogoNascita(String luogoNascita) {this.luogoNascita = luogoNascita;}
    public void setProvinciaNascita(String provinciaNascita) {this.provinciaNascita = provinciaNascita;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setTelefonoParente(String telefonoParente) {this.telefonoParente = telefonoParente;}


    public List<Diagnosi> getDiagnosi() {
        return diagnosi;
    }

    public void setDiagnosi(ArrayList<Diagnosi> diagnosi) {
        this.diagnosi = diagnosi;
    }

    public long getId() {
        return id;
    }

    public List<Visita> getVisita() {
        return visita;
    }

    public void setVisita(List<Visita> visita) {
        this.visita = visita;
    }

    public void addVisita(Visita v){
        visita.add(v);
    }

    public void addDiagnosi(Diagnosi d){
        diagnosi.add(d);
    }
}
