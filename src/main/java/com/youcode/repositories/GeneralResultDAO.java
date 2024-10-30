package com.youcode.repositories;

import com.youcode.models.entities.Competition;
import com.youcode.models.entities.GeneralResult;
import com.youcode.models.entities.embeddables.GeneralResultKey;
import com.youcode.repositories.base.BaseDAO;
import com.youcode.repositories.interfaces.GenralResultDAOIntrf;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GeneralResultDAO extends BaseDAO<GeneralResult, GeneralResultKey> implements GenralResultDAOIntrf {

    public GeneralResultDAO(SessionFactory sessionFactory) {
        super(GeneralResult.class, sessionFactory);

    }
    @Override
    public List<GeneralResult> getGenralResultsByCompetition(Competition competition){
        try(Session s = openSession()){
            String query = "FROM GeneralResult g WHERE g.competition = :competition";
            return s.createQuery(query , GeneralResult.class)
                    .setParameter("competition" , competition)
                    .getResultList();
        }
    }

}
