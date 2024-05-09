package com.project.talenteer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Quiz;
import com.project.talenteer.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin
public class QuizController {


    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/getall")
	public DataResult<List<Quiz>> getAll(){
		return this.quizService.getAll();
	}
}
