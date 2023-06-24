package com.ism.jpasecurity.repositories;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 01:52
 * Project : JpaSecurity $
 */
import com.ism.jpasecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

