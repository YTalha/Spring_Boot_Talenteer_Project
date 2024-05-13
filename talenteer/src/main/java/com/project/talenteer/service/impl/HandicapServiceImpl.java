package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Handicap;
import com.project.talenteer.repository.HandicapRepository;
import com.project.talenteer.service.HandicapService;

@Service
public class HandicapServiceImpl implements HandicapService{

    private final HandicapRepository handicapRepository;
    private final UserRepository userRepository;

    @Autowired
    public HandicapServiceImpl(HandicapRepository handicapRepository,UserRepository userRepository){
        this.handicapRepository = handicapRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<Handicap> saveHandicap(Handicap handicap) {
        User user = userRepository.findById(handicap.getUser().getId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + handicap.getUser().getId()));
    handicap.setUser(user);
    return new SuccessDataResult<>(handicapRepository.save(handicap), "Education saved successfully.");
    }

    @Override
    public DataResult<Handicap> getHandicapByUserId(int userId) {
        return new SuccessDataResult<>(handicapRepository.findById(userId).orElse(null), "Education found by user id.");
    }

}
