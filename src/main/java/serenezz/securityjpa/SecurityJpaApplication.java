package serenezz.securityjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import serenezz.securityjpa.domain.User;
import serenezz.securityjpa.repo.UserRepo;

import java.util.List;

@SpringBootApplication
public class SecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepo userRepo, PasswordEncoder passwordEncoder){
		return args -> {
			User manager = new User();
			manager.setUsername("manager");
			manager.setPassword(passwordEncoder.encode("password"));
			manager.setRoles("ROLE_MANAGER");

			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("password"));
			admin.setRoles("ROLE_MANAGER,ROLE_ADMIN");
			userRepo.saveAll(List.of(manager,admin));
		};
	}

}
