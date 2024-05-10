package com.project.talenteer.service.impl;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Education;
import com.project.talenteer.repository.EducationRepository;
import com.project.talenteer.service.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final UserRepository userRepository; 

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository,UserRepository userRepository) {
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<Education> saveEducation(Education education) {
    User user = userRepository.findById(education.getUser().getId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + education.getUser().getId()));
    education.setUser(user);
    return new SuccessDataResult<>(educationRepository.save(education), "Education saved successfully.");
    }


    @Override
    public DataResult<Education> getEducationByUserId(int userId) {
        return new SuccessDataResult<>(educationRepository.findById(userId).orElse(null), "Education found by user id.");
    }
}
