package com.example.app.tasktracker.dto.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class GoalDTO {
    @NotBlank
    private String name;

    @Size(max=500)
    private String description;

    @Min(0)
    @NotNull
    private Double targetHours;

    @Temporal(TemporalType.DATE)  // To store only the date without time.
    @FutureOrPresent(message = "The date must be today or in the future")
    private Date dueDate;
}
