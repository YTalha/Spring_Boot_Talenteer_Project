package com.project.talenteer.controller;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Education;
import com.project.talenteer.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/save")
    public DataResult<Education> saveEducation(@RequestBody Education education) {
        return educationService.saveEducation(education);
    }

    @GetMapping("/educationUser/{userId}")
    public DataResult<Education> getEducationByUserId(@PathVariable int userId) {
        return educationService.getEducationByUserId(userId);
    }
}
