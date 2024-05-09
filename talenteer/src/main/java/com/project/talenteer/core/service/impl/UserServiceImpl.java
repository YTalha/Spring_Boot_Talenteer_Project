package com.project.talenteer.core.service.impl;

import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.repository.UserRepository;
import com.project.talenteer.core.service.UserService;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.ErrorDataResult;
import com.project.talenteer.core.utilities.result.Result;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.core.utilities.result.SuccessResult;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
		this.userRepository.save(user);
		return new SuccessResult("eklendi");
	}

    @Override
    public DataResult<User> login(String email, String password) {
        User user = this.userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return new SuccessDataResult<>(user,"Giriş başarılı.");
        }

        return new ErrorDataResult<>("Giriş başarısız. Kullanıcı adı veya şifre hatalı.");
    }

    @Override
    public DataResult<User> findByEmail(String Email) {
		return new SuccessDataResult<User>(this.userRepository.findByEmail(Email),"kullanıcı bulundu"); 
	}
}
