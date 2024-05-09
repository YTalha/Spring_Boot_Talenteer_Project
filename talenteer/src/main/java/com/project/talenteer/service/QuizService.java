package com.project.talenteer.service;

import java.util.List;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Quiz;

public interface QuizService {
    DataResult<List<Quiz>> getAll();
}
