package univr.Models.Repositories;

import univr.Models.Farmaco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmacoRepository extends CrudRepository<Farmaco, Long> {

    Farmaco findById( long id);
}
