package com.gym.TrainingReports.service;

import com.gym.TrainingReports.model.TrainingReports;
import com.gym.TrainingReports.repository.TrainingReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingReportsService {
    private final TrainingReportsRepository trainingReportsRepository;

    @Autowired
    public TrainingReportsService(TrainingReportsRepository trainingReportsRepository) {
        this.trainingReportsRepository = trainingReportsRepository;
    }

    public void saveTrainingReports(TrainingReports trainingReports) {
        trainingReportsRepository.save(trainingReports);
    }

    public List<TrainingReports> getMonthlyReports(int idLearner, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        return trainingReportsRepository.findReportsByLearnerAndDate(idLearner, startDate, endDate);
    }
}
