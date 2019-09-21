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
	private BCryptPasswordEncoder bc;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User gabriela = new User(null, "Gabriela", "zooiv3rde@gmail.com", bc.encode("123"));
		gabriela.addProfile(Profile.ADMIN);

		userRepository.deleteAll();
		userRepository.saveAll(Arrays.asList(gabriela));
	}

}
