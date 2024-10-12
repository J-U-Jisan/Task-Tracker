package com.example.app.tasktracker.controller;

import com.example.app.tasktracker.dto.request.GoalDTO;
import com.example.app.tasktracker.model.Goal;
import com.example.app.tasktracker.service.impl.GoalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    @Autowired
    GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    /**
     * Create goal
     * @param goalDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<Goal> create(@RequestBody @Valid GoalDTO goalDTO) {

        Goal goal = mapGoalDTOWithGoalEntity(goalDTO);

        Goal savedGoal = goalService.create(goal);

        return new ResponseEntity<>(savedGoal, HttpStatus.CREATED);
    }

    /**
     * Map GoalDTO class with Goal Entity
     * @param goalDTO
     * @return
     */
    private Goal mapGoalDTOWithGoalEntity(GoalDTO goalDTO) {
        Goal goal = new Goal();

        goal.setName(goalDTO.getName());
        goal.setDescription(goalDTO.getDescription());
        goal.setTargetHours(goalDTO.getTargetHours());
        goal.setDueDate(goalDTO.getDueDate());

        return goal;
    }
}
