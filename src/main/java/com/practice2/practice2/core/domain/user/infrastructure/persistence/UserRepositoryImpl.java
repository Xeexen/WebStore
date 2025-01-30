package com.practice2.practice2.core.domain.user.infrastructure.persistence;

import com.practice2.practice2.core.domain.user.domain.User;
import com.practice2.practice2.core.domain.user.domain.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {
    private final JpaImplUserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRepositoryImpl(JpaImplUserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User Register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
}
