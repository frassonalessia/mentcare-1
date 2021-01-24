package univr.Models.Repositories;

import univr.Models.Prescrizione;
import univr.Models.Visita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescrizioneRepository extends CrudRepository<Prescrizione, Long> {

    Prescrizione findById( long id);
    List<Prescrizione> findByVisita(Visita visita);
}
