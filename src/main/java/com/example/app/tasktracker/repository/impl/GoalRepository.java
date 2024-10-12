package com.example.app.tasktracker.repository.impl;

import com.example.app.tasktracker.model.Goal;
import com.example.app.tasktracker.util.AuditLog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoalRepository implements com.example.app.tasktracker.repository.GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**

     */
    @Override
    @Transactional
    public Goal create(Goal goal) {
        AuditLog.setTimeStamps(goal, true);

        String sql = "INSERT INTO goals (name, description, target_hours, due_date, created_on, last_updated_on)" +
                " VALUES ( :name, :description, :targetHours, :dueDate, :createdOn, :lastUpdatedOn )";
        
        // Insert goal object in database
        entityManager.createNativeQuery(sql)
                .setParameter("name", goal.getName())
                .setParameter("description", goal.getDescription())
                .setParameter("targetHours", goal.getTargetHours())
                .setParameter("dueDate", goal.getDueDate())
                .setParameter("createdOn", goal.getCreatedOn())
                .setParameter("lastUpdatedOn", goal.getLastUpdatedOn())
                .executeUpdate();

        // Retrieve the last inserted ID (Primary key)
        Object id = entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();

        // Set the generated ID on the goal object
        goal.setId((Long) id);

        // Return the goal object with the generated ID
        return goal;
    }

    @Override
    public Goal update(Goal goal) {
        return null;
    }

    @Override
    public Goal findById(Long id) {
        return null;
    }

    @Override
    public List<Goal> findAll() {
        return null;
    }

    @Override
    public void delete(Goal goal) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
