package repository.VoitureRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Cat;

@Repository
public interface VoitureRepository extends CrudRepository<Voiture, Long> {
}
