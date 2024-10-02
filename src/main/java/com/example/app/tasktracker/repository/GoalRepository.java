package com.example.app.tasktracker.repository;

import com.example.app.tasktracker.model.Goal;

import java.util.List;

public interface GoalRepository {
    Goal create(Goal goal);
    Goal update(Goal goal);
    Goal findById(Long id);
    List<Goal> findAll();
    void deleteById(Long id);
}
