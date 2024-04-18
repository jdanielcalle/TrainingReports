package com.gym.TrainingReports.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.gym.TrainingReports.model.TrainingReports;

import java.time.LocalDate;
import java.util.List;

public interface TrainingReportsRepository extends MongoRepository<TrainingReports, String> {
    List<TrainingReports> findReportsByLearnerAndDate(int learnerId, LocalDate startDate, LocalDate endDate);
}
