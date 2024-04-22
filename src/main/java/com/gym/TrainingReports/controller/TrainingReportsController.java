package com.gym.TrainingReports.controller;

import com.gym.TrainingReports.model.TrainingReports;
import com.gym.TrainingReports.service.TrainingReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.gym.TrainingReports.exception.TrainingReportNotFoundException;
import com.gym.TrainingReports.exception.InvalidTrainingReportException;

import java.util.List;


@RestController
@RequestMapping("/api/training-reports")
@Validated
public class TrainingReportsController {
    private final TrainingReportsService trainingReportsService;

    @Autowired
    public TrainingReportsController(TrainingReportsService trainingReportsService) {
        this.trainingReportsService = trainingReportsService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTrainingReport(@RequestBody TrainingReports trainingReports) {
        try {
            trainingReportsService.saveTrainingReports(trainingReports);
            return ResponseEntity.ok().build();
        } catch (InvalidTrainingReportException e) {
            return ResponseEntity.badRequest().body("Invalid training report: " + e.getMessage());
        }
    }

    @GetMapping("/monthly-reports/{idLearner}/{month}/{year}")
    public ResponseEntity<List<TrainingReports>> getMonthlyReports(@PathVariable int idLearner, @PathVariable int month, @PathVariable int year) {
        try {
            List<TrainingReports> reports = trainingReportsService.getMonthlyReports(idLearner, month, year);
            return ResponseEntity.ok(reports);
        } catch (TrainingReportNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(TrainingReportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTrainingReportNotFoundException(TrainingReportNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidTrainingReportException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidTrainingReportException(InvalidTrainingReportException ex) {
        return ex.getMessage();
    }
}
