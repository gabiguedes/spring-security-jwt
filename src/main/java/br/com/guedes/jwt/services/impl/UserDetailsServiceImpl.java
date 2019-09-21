package br.com.guedes.jwt.services.impl;

import br.com.guedes.jwt.entities.User;
import br.com.guedes.jwt.entities.enums.Profile;
import br.com.guedes.jwt.repositories.UserRepository;
import br.com.guedes.jwt.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(email);
        }


        return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getProfiles());
    }
}
