package service.VoitureService;

import org.springframework.stereotype.Service;
import com.example.model.Voiture;
import com.example.repository.VoitureRepository;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    private final VoitureRepository repository;

    public Voiture findById(long id) throws Exception {
        Optional<Voiture> oCat = VoitureRepository.findById(id);
        if (oCat.isEmpty()) {
            throw new Exception("Empty");
        }
        return oCat.get();
    }

    public Voiture findAll() {
        return repository.findAll();
    }

    public Voiture save(Voiture cat) {
        return repository.save(cat);
    }

    public Voiture update(Voiture cat) {
        return repository.save(cat);
    }
    
    public Voiture delete(String id) {
        repository.deleteById(id);
        return cat;
    }
}
