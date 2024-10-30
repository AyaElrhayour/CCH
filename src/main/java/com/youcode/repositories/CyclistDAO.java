package com.youcode.repositories;

import com.youcode.models.entities.Cyclist;
import com.youcode.models.entities.Team;
import com.youcode.repositories.base.BaseDAO;
import com.youcode.repositories.interfaces.CyclistDAOIntrf;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class CyclistDAO extends BaseDAO<Cyclist, UUID> implements CyclistDAOIntrf {

    public CyclistDAO(SessionFactory sessionFactory) {
        super(Cyclist.class, sessionFactory);
    }

    @Override
    public List<Cyclist> getCyclistsByName() {
        try(Session session = openSession()){
            TypedQuery<Cyclist> query = session.createQuery("FROM Cyclist c ORDER BY firstName", Cyclist.class);
            return query.getResultList();
        }
    }

    @Override
    public List<Cyclist> getCyclistsByNationality() {
        try(Session session = openSession()) {
            TypedQuery<Cyclist> query = session.createQuery("FROM Cyclist c ORDER BY nationality" , Cyclist.class);
            return query.getResultList();
        }
    }

    @Override
    public List<Cyclist> getCyclistsByTeam() {
        try(Session session = openSession()) {
            TypedQuery<Cyclist> query = session.createQuery("SELECT c FROM Cyclist c JOIN c.team t ORDER BY t.name" , Cyclist.class);
            return query.getResultList();
        }
    }

    @Override
    public List<Cyclist> getCyclistsOfTeam(Team team) {
        try(Session session = openSession()) {
            String query = "FROM Cyclist c WHERE c.team = :team";
            return session.createQuery(query , Cyclist.class)
                    .setParameter("team" , team)
                    .getResultList();
        }
    }
}
