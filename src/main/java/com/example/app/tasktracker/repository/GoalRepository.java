package com.example.app.tasktracker.repository;

import com.example.app.tasktracker.model.Goal;

import java.util.List;

public interface GoalRepository {

    Goal create(Goal goal) throws Exception; // Create
    Goal update(Goal goal); // Update
    Goal findById(Long id);
    List<Goal> findAll();
    void delete(Goal goal);
    void deleteById(Long id);
}
