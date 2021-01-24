package univr.Models.Repositories;

import univr.Models.Diagnosi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import univr.Models.Paziente;

import java.util.ArrayList;

@Repository
public interface DiagnosiRepository extends CrudRepository<Diagnosi, Long> {

    Diagnosi findById (long id);
    ArrayList<Diagnosi> findByPaziente(Paziente paziente);

}