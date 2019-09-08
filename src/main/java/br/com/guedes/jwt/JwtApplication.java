package br.com.guedes.jwt;

import br.com.guedes.jwt.entities.User;
import br.com.guedes.jwt.entities.enums.Profile;
import br.com.guedes.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User gaby = new User(null, "admin", "gabriela_rayssa@hotmail.com",
				bCryptPasswordEncoder.encode("123"));
				gaby.addProfile(Profile.ADMIN);

		userRepository.saveAll(Arrays.asList(gaby));
	}

}
