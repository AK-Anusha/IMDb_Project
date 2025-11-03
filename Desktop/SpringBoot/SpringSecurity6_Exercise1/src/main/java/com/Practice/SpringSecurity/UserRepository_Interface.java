package com.Practice.SpringSecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository_Interface extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String Username);
}
