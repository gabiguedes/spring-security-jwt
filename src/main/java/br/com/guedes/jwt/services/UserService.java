package br.com.guedes.jwt.services;

import br.com.guedes.jwt.dto.UserNewDTO;
import br.com.guedes.jwt.entities.User;
import br.com.guedes.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User fromDTO(UserNewDTO objDto) {
        User user = new User(null, objDto.getName(), bCryptPasswordEncoder.encode(objDto.getPassword()));
        return user;
    }

}
