package com.example.app.tasktracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "goals")
public class Goal extends BaseEntity{

    @NotNull
    private String name;

    @Max(500)
    private String description;

    @Min(0)
    @NotNull
    private Double targetHours;

    @Temporal(TemporalType.DATE)  // To store only the date without time.
    @FutureOrPresent(message = "The date must be today or in the future")
    private Date dueDate;
}
