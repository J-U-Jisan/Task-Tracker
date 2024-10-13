package com.example.app.tasktracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "goals")
public class Goal extends BaseEntity{

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
