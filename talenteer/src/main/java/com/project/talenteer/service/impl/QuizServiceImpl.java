package com.project.talenteer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Quiz;
import com.project.talenteer.repository.QuizRepository;
import com.project.talenteer.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    @Override
    public DataResult<List<Quiz>> getAll() {
        return new SuccessDataResult<List<Quiz>>(this.quizRepository.findAll(), "Data Listelendi");
    }

}
