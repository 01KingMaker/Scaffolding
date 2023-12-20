package controlleur.VoitureController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.openclassrooms.api.model.Voiture;
import com.openclassrooms.api.service.VoitureService;

@RestController("/Voiture")
public class VoitureController {
    
    @Autowired
    private VoitureService service;
    
    @GetMapping("/")
    public Iterable<Voiture> getVoiture() {
       return service.getVoiture();
    }
    @GetMapping("/{id}")
    public Iterable<Voiture> getVoiture(@PathVariable String id) {
       return service.getVoiture(id);
    }
    @PostMapping("/")
    public Iterable<Voiture> saveVoiture() {
        return service.saveVoiture();
    }
    @PutMapping("/")
    public Iterable<Voiture> updateVoiture() {
        return service.updateVoiture();
    }
    @DeleteMapping("/{id}")
    public Iterable<Voiture> deleteVoiture(@PathVariable Long id) {
        return service.deleteVoiture(id);
    }
}
