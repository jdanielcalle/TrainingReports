package com.gym.TrainingReports.repository;

import com.gym.TrainingReports.model.TrainingReports;
import com.gym.TrainingReports.repository.TrainingReportsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TrainingReportsRepositoryTest {
    @Autowired
    private TrainingReportsRepository trainingReportsRepository;

    @Test
    void findReportsByLearnerAndDate_WhenNoReportsFound_ShouldReturnEmptyList() {
        int idLearner = 1;
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);

        List<TrainingReports> reports = trainingReportsRepository.findReportsByLearnerAndDate(idLearner, startDate, endDate);

        assertThat(reports).isEmpty();
    }
}
