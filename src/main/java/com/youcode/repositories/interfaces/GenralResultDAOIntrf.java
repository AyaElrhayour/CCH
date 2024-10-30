package com.youcode.repositories.interfaces;

import com.youcode.models.entities.Competition;
import com.youcode.models.entities.GeneralResult;
import com.youcode.models.entities.embeddables.GeneralResultKey;
import com.youcode.repositories.base.BaseDAOIntf;

import java.util.List;

public interface GenralResultDAOIntrf extends BaseDAOIntf<GeneralResult, GeneralResultKey> {

    List<GeneralResult> getGenralResultsByCompetition(Competition competition);
}
