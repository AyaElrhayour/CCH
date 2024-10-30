package com.youcode.repositories;

import com.youcode.models.entities.Competition;
import com.youcode.repositories.base.BaseDAO;
import com.youcode.repositories.interfaces.CompetitionDAOInterf;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class CompetitionDAO extends BaseDAO<Competition, UUID> implements CompetitionDAOInterf {
    public CompetitionDAO(SessionFactory sessionFactory) {
        super(Competition.class, sessionFactory);
    }
}
