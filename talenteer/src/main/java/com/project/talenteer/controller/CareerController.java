package com.project.talenteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Career;
import com.project.talenteer.service.CareerService;

@RestController
@RequestMapping("/api/careers")
public class CareerController {

    private final CareerService careerService;

    @Autowired
    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @PostMapping("/save")
    public DataResult<Career> saveCareer(@RequestBody Career career) {
        return careerService.saveCareer(career);
    }

    @GetMapping("/careerUser/{userId}")
    public DataResult<Career> getCareerByUserId(@PathVariable int userId) {
        return careerService.getCareerByUserId(userId);
    }
}
