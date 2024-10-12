package com.example.app.tasktracker.service.impl;

import com.example.app.tasktracker.model.Goal;
import com.example.app.tasktracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService implements com.example.app.tasktracker.service.GoalService {

    private final GoalRepository goalRepository;

    @Autowired
    GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }


    /**
     * Create goal using Goal class
     * @param goal
     * @return
     */
    @Override
    public Goal create(Goal goal) {
        return goalRepository.create(goal);
    }
}
