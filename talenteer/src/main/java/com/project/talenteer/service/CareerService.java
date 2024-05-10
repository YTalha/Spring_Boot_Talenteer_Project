package com.project.talenteer.service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Career;

public interface CareerService {
    DataResult<Career> saveCareer(Career career);
    DataResult<Career> getCareerByUserId(int userId);

}
