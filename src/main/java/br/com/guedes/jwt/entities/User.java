package br.com.guedes.jwt.entities;

import br.com.guedes.jwt.entities.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Set<Integer> profiles = new HashSet<>();

    public User() {
        addProfile(Profile.ADMIN);
    }

    public User(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        addProfile(Profile.ADMIN);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Profile> getProfile() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCod());
    }

    public Set<Integer> getProfiles() {
        return profiles;
    }
}
