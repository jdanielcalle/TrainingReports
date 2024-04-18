package com.gym.TrainingReports.controller;

import com.gym.TrainingReports.model.TrainingReports;
import com.gym.TrainingReports.service.TrainingReportsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/training-reports")
public class TrainingReportsController {
    private final TrainingReportsService trainingReportsService;

    @Autowired
    public TrainingReportsController(TrainingReportsService trainingReportsService) {
        this.trainingReportsService = trainingReportsService;
    }

    @PostMapping("/save")
    public void saveTrainingReport(@RequestBody TrainingReports trainingReports) {
        trainingReportsService.saveTrainingReports(trainingReports);
    }

    @GetMapping("/monthly-reports/{idLearner}/{month}/{year}")
    public List<TrainingReports> getMonthlyReports(@PathVariable int idLearner, @PathVariable int month, @PathVariable int year) {
        return trainingReportsService.getMonthlyReports(idLearner, month, year);
    }
}
