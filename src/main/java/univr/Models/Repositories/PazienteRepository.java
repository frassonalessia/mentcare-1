package univr.Models.Repositories;

import univr.Models.Paziente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends CrudRepository<Paziente, Long> {

    Paziente findById (long id);
    //Paziente findByCodiceFiscale (String codiceFiscale);

}
