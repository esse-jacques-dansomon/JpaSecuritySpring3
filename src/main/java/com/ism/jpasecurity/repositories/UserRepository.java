package com.ism.jpasecurity.repositories;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 01:52
 * Project : JpaSecurity
 */
import com.ism.jpasecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

