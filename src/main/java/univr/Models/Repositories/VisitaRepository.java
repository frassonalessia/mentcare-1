package univr.Models.Repositories;

import univr.Models.Paziente;
import univr.Models.Visita;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VisitaRepository extends CrudRepository<Visita, Long> {
    Visita findById(long id);
    ArrayList<Visita> findByPaziente(Paziente paziente);
}
