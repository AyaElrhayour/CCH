package com.youcode.repositories;

import com.youcode.models.entities.Competition;
import com.youcode.models.entities.Stage;
import com.youcode.repositories.base.BaseDAO;
import com.youcode.repositories.interfaces.StageDAOInterf;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class StageDAO extends BaseDAO<Stage, UUID> implements StageDAOInterf {

    public StageDAO(SessionFactory sessionFactory) {
        super(Stage.class, sessionFactory);
    }

    @Override
    public List<Stage> getStagesOfCompetition(Competition competition) {
        try(Session session = openSession()){
            String query = "FROM Stage s WHERE s.competition = :competition";
            return session.createQuery(query , Stage.class)
                    .setParameter("competition" , competition)
                    .getResultList();
        }
    }

    @Override
    public void setStagesAsCompleted(Stage stage) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            Stage s = session.get(Stage.class, stage.getId());
            s.setCompleted(true);
            session.merge(s);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Transaction rolled back due to: " + e.getMessage());
            }
        }
    }
}
