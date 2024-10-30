package com.youcode.repositories.interfaces;

import com.youcode.models.entities.Cyclist;
import com.youcode.models.entities.Team;
import com.youcode.repositories.base.BaseDAOIntf;

import java.util.List;
import java.util.UUID;

public interface CyclistDAOIntrf extends BaseDAOIntf<Cyclist, UUID> {
    List<Cyclist> getCyclistsByName();
    List<Cyclist> getCyclistsByNationality();
    List<Cyclist> getCyclistsByTeam();
    List<Cyclist> getCyclistsOfTeam(Team team);
}
