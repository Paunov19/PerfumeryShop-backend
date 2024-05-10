package com.perfumery.perfumerywebapp.repositories;

import com.perfumery.perfumerywebapp.enums.ERole;
import com.perfumery.perfumerywebapp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
