package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Career;
import com.project.talenteer.repository.CareerRepository;
import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.service.CareerService;
import com.project.talenteer.core.utilities.result.SuccessDataResult;

@Service
public class CareerServiceImpl implements CareerService{

    private final CareerRepository careerRepository;
    private final UserRepository userRepository; 

    @Autowired
    public CareerServiceImpl(CareerRepository careerRepository, UserRepository userRepository) {
        this.careerRepository = careerRepository;
        this.userRepository = userRepository; 
    }

    @Override
    public DataResult<Career> saveCareer(Career career) {
        User user = userRepository.findById(career.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + career.getUser().getId()));
        career.setUser(user);
        return new SuccessDataResult<>(careerRepository.save(career), "Career saved successfully.");
    }

    @Override
    public DataResult<Career> getCareerByUserId(int id) {
        return new SuccessDataResult<>(careerRepository.findById(id).orElse(null), "Career found by user id.");
    }
}
