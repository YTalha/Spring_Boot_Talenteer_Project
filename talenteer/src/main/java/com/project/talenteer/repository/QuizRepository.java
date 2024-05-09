package com.project.talenteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.talenteer.model.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
