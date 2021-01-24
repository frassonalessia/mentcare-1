package univr.Models;

import javax.persistence.*;

@Entity
public class Farmaco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;

    private String nome;
    //private HashMap<String, Integer> prinicipi_attivi = new HashMap<String, Integer>();
    //private ArrayList<String> effetti_collaterali = new ArrayList<String>();

    protected Farmaco(){}

    public Farmaco(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

}
