package com.practice2.practice2.core.domain.user.domain;

public interface UserRepository {

    User Register(User user);

    User findByEmail(String email);

}
