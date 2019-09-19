package br.com.guedes.jwt;

import br.com.guedes.jwt.dto.UserNewDTO;
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
		User gaby = new User(null, "gaby", bCryptPasswordEncoder.encode("123"), "zooiv3rde@gmail.com");
		User gabriela = new User(null, "admin", bCryptPasswordEncoder.encode("123"), "tetsf");
		User gabriela1 = new User(null, "ROLE_ADMIN", "123", "gabriela_rayssa@hotmail.com");
        gaby.addProfile(Profile.ADMIN);

		userRepository.deleteAll();
		userRepository.saveAll(Arrays.asList(gaby, gabriela, gabriela1));
	}

}
