package com.gym.TrainingReports.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingReports {
    private Integer idReport;
    private Integer idTrainee;
    private String nameTrainee;
    private Integer idTrainer;
    private String nameTrainer;
    private LocalDate trainingDate;
    private String trainingType;
    private String trainingDuration;

    public boolean isValidTrainingDate() {
        return trainingDate != null && trainingDate.isBefore(LocalDate.now());
    }

    public boolean isValidTrainingDuration() {
        return trainingDuration != null && !trainingDuration.isEmpty();
    }

    public boolean isValid() {
        return isValidTrainingDate() && isValidTrainingDuration();
    }
}