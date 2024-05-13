package com.project.talenteer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Talent;
import com.project.talenteer.repository.TalentRepository;
import com.project.talenteer.service.TalentService;

@Service
public class TalentServiceImpl implements TalentService{

    private final TalentRepository talentRepository;
    private final UserRepository userRepository;

    @Autowired
    public TalentServiceImpl(TalentRepository talentRepository, UserRepository userRepository){
        this.talentRepository = talentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<Talent> saveTalent(Talent talent) {
        User user = userRepository.findById(talent.getUser().getId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + talent.getUser().getId()));
    talent.setUser(user);
    return new SuccessDataResult<>(talentRepository.save(talent), "Education saved successfully.");
    }

    @Override
    public DataResult<Talent> getTalentByUserId(int userId) {
        return new SuccessDataResult<>(talentRepository.findById(userId).orElse(null), "Education found by user id.");
    }

}
