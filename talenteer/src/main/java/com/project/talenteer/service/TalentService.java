package com.project.talenteer.service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Talent;

public interface TalentService {
    DataResult<Talent> saveTalent(Talent talent);
    DataResult<Talent> getTalentByUserId(int userId);
}
