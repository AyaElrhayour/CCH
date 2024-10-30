package com.youcode.repositories.interfaces;

import com.youcode.models.entities.Competition;
import com.youcode.models.entities.Stage;
import com.youcode.repositories.base.BaseDAOIntf;

import java.util.List;
import java.util.UUID;

public interface StageDAOInterf extends BaseDAOIntf<Stage, UUID> {


    List<Stage> getStagesOfCompetition (Competition competition);
    void setStagesAsCompleted (Stage stage);
}
