package com.project.talenteer.core.service;

import com.project.talenteer.core.entity.User;
import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> login(String email, String password);
    DataResult<User> findByEmail(String Email);
}
