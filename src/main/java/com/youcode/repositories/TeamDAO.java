package com.youcode.repositories;

import com.youcode.models.entities.Team;
import com.youcode.repositories.base.BaseDAO;
import com.youcode.repositories.interfaces.TeamDAOIntrf;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class TeamDAO extends BaseDAO<Team, UUID> implements TeamDAOIntrf {

    public TeamDAO(SessionFactory sessionFactory) {
        super(Team.class, sessionFactory);
    }
}
