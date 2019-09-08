package br.com.guedes.jwt.repositories;

import br.com.guedes.jwt.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Transactional(readOnly = true)
    User findByEmail(String email);

}
