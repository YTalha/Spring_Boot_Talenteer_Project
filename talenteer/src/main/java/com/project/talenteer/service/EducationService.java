package com.project.talenteer.service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Education;

public interface EducationService {
    DataResult<Education> saveEducation(Education education);
    DataResult<Education> getEducationByUserId(int userId);
}
