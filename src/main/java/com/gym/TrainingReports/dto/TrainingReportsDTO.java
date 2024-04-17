package com.gym.TrainingReports.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingReportsDTO {
    private int idTrainee;
    private String nameTrainee;
    private int idTrainer;
    private String nameTrainer;
    private LocalDate trainingDate;
    private String trainingType;
    private String trainingDuration;
}
