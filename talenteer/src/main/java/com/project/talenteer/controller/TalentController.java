package com.project.talenteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Talent;
import com.project.talenteer.service.TalentService;

@RestController
@RequestMapping("/api/talent")
@CrossOrigin
public class TalentController {

    private final TalentService talentService;

    @Autowired
    public TalentController(TalentService talentService){
        this.talentService = talentService;
    }

    @PostMapping("/save")
    public DataResult<Talent> saveTalent(@RequestBody Talent talent) {
        return talentService.saveTalent(talent);
    }

    @GetMapping("/talentUser/{userId}")
    public DataResult<Talent> getTalentByUserId(@PathVariable int userId) {
        return talentService.getTalentByUserId(userId);
    }

}
