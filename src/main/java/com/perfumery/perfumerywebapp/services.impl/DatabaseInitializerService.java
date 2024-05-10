package com.perfumery.perfumerywebapp.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfumery.perfumerywebapp.bootstrap.ParsedPerfume;
import com.perfumery.perfumerywebapp.bootstrap.ParsedPerfumeMapper;
import com.perfumery.perfumerywebapp.enums.ERole;
import com.perfumery.perfumerywebapp.models.Perfume;
import com.perfumery.perfumerywebapp.models.Role;
import com.perfumery.perfumerywebapp.models.User;
import com.perfumery.perfumerywebapp.repositories.PerfumeRepository;
import com.perfumery.perfumerywebapp.repositories.RoleRepository;
import com.perfumery.perfumerywebapp.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DatabaseInitializerService {
    public static final String PERFUME_FILE = "src/main/java/com/perfumery/testdata/AllPerfumes.json";

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PerfumeRepository perfumeRepository;

    @Autowired
    private UserRepository userRepository;

    private ParsedPerfume[] parsedPerfumes;

    private void loadRecipesFromJson() {
        File file = new File(PERFUME_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            parsedPerfumes = objectMapper.readValue(file, ParsedPerfume[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateDB() {
        loadRecipesFromJson();
        List<Perfume> allPerfumes = new ArrayList<>();
        allPerfumes = Arrays.stream(parsedPerfumes).map(ParsedPerfumeMapper::toPerfume).collect(Collectors.toList());
        perfumeRepository.saveAll(allPerfumes);
        seedRoles();
        seedUsers();
    }

    private void seedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(ERole.ROLE_USER));
        roles.add(new Role(ERole.ROLE_ADMIN));
        roles.add(new Role(ERole.ROLE_EMPLOYEE));
        roleRepository.saveAll(roles);
    }

    private void seedUsers() {
        List<User> users = new ArrayList<>();

        User user = new User("Даяна", "Кирилова", "daqna@daqna.com", "$2a$10$rzJlTmOzowWWt0XrvIKar.dUE6.xEVEOD5knqmuUfMwoR19QFp01W");
        var roles = user.getRoles();
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();
        roles.add(role);
        user.setRoles(roles);
        users.add(user);

        userRepository.saveAll(users);
    }
}
