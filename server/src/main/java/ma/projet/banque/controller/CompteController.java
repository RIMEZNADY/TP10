package ma.projet.banque.controller;

import ma.projet.banque.entities.Compte;
import ma.projet.banque.entities.CompteListWrapper;
import ma.projet.banque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banque")
@CrossOrigin(origins = "*")
public class CompteController {
    
    @Autowired
    private CompteRepository compteRepository;
    
    @GetMapping(value = "/comptes")
    public ResponseEntity<?> getAllComptes(HttpServletRequest request) {
        String acceptHeader = request.getHeader(HttpHeaders.ACCEPT);
        List<Compte> comptes = compteRepository.findAll();
        
        if (acceptHeader != null && acceptHeader.contains("application/xml")) {
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(new CompteListWrapper(comptes));
        } else {
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(comptes);
        }
    }
    
    @GetMapping("/comptes/{id}")
    public Compte getCompteById(@PathVariable Long id) {
        return compteRepository.findById(id).orElse(null);
    }
    
    @PostMapping("/comptes")
    public Compte addCompte(@RequestBody Compte compte) {
        if (compte.getDateCreation() == null || compte.getDateCreation().isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            compte.setDateCreation(formatter.format(Calendar.getInstance().getTime()));
        }
        return compteRepository.save(compte);
    }
    
    @PutMapping("/comptes/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte compte) {
        Optional<Compte> existingCompte = compteRepository.findById(id);
        if (existingCompte.isPresent()) {
            Compte c = existingCompte.get();
            c.setSolde(compte.getSolde());
            c.setType(compte.getType());
            return compteRepository.save(c);
        }
        return null;
    }
    
    @DeleteMapping("/comptes/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
