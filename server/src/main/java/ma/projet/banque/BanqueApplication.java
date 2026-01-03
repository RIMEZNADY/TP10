package ma.projet.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ma.projet.banque.entities")
@EnableJpaRepositories("ma.projet.banque.repository")
public class BanqueApplication {
    public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
    }
}

