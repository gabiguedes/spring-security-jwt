package br.com.guedes.jwt.services;

import br.com.guedes.jwt.dto.UserNewDTO;
import br.com.guedes.jwt.entities.User;
import br.com.guedes.jwt.entities.enums.Profile;
import br.com.guedes.jwt.repositories.UserRepository;
import br.com.guedes.jwt.security.UserSS;
import br.com.guedes.jwt.services.exceptions.AuthorizationException;
import br.com.guedes.jwt.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User find(String id) {
        UserSS userSS = UserService.autheticated();

        if(userSS == null || !userSS.hasRole(Profile.ADMIN) && !id.equals(userSS.getId())) {
            throw new AuthorizationException("Acess danied");
        }

        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + User.class.getName()));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User fromDTO(UserNewDTO objDto) {
        User user = new User(null, objDto.getName(), objDto.getEmail(), bCryptPasswordEncoder.encode(objDto.getPassword()));
        return user;
    }

    public static UserSS autheticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
