package com.project.talenteer.service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Handicap;

public interface HandicapService {
    DataResult<Handicap> saveHandicap(Handicap handicap);
    DataResult<Handicap> getHandicapByUserId(int userId);
}
