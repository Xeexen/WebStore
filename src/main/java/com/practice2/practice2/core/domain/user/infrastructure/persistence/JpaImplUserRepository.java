package com.practice2.practice2.core.domain.user.infrastructure.persistence;

import com.practice2.practice2.core.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaImplUserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
}
