package ma.projet.banque.config;

import ma.projet.banque.entities.Compte;
import ma.projet.banque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private CompteRepository compteRepository;
    
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(Calendar.getInstance().getTime());
        
        // Ajouter quelques comptes de test
        compteRepository.save(new Compte(null, 1000.0, "COURANT", date));
        compteRepository.save(new Compte(null, 5000.0, "EPARGNE", date));
        compteRepository.save(new Compte(null, 2500.0, "COURANT", date));
        
        System.out.println("Données initiales chargées avec succès!");
    }
}

