package com.asymmetric.service;

import com.asymmetric.entity.Role;
import com.asymmetric.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        resetUserData();
        createRoleIfNotExists("ROLE_USER");
    }

    private void resetUserData() {
        this.jdbcTemplate.execute("TRUNCATE TABLE users_roles, users RESTART IDENTITY CASCADE");
    }

    private void createRoleIfNotExists(String roleName) {
        if (this.roleRepository.findByName(roleName).isEmpty()) {
            final Role role = Role.builder()
                    .name(roleName)
                    .createdBy("SYSTEM")
                    .lastModifiedBy("SYSTEM")
                    .build();

            this.roleRepository.save(role);
        }
    }

}