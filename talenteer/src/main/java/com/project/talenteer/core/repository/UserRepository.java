package com.project.talenteer.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.talenteer.core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
        User findByEmail(String email);
}
