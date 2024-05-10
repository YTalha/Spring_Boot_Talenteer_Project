package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Career;
import com.project.talenteer.repository.CareerRepository;
import com.project.talenteer.service.CareerService;
import com.project.talenteer.core.utilities.result.SuccessDataResult;

public class CareerServiceImpl implements CareerService{

    private final CareerRepository careerRepository;

    @Autowired
    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    @Override
    public DataResult<Career> saveCareer(Career career) {
        return new SuccessDataResult<>(careerRepository.save(career), "Career saved successfully.");
    }

    @Override
    public DataResult<Career> getCareerByUserId(int id) {
        return new SuccessDataResult<>(careerRepository.findById(id).orElse(null), "Career found by user id.");
    }
}
