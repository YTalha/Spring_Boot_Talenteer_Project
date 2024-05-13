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
import com.project.talenteer.model.entity.Handicap;
import com.project.talenteer.service.HandicapService;

@RestController
@RequestMapping("/api/handicap")
@CrossOrigin
public class HandicapController {   

    private final HandicapService handicapService;

    @Autowired
    public HandicapController(HandicapService handicapService){
        this.handicapService = handicapService;
    }

    @PostMapping("/save")
    public DataResult<Handicap> saveHandicap(@RequestBody Handicap handicap) {
        return handicapService.saveHandicap(handicap);
    }

    @GetMapping("/handicapUser/{userId}")
    public DataResult<Handicap> getHandicapByUserId(@PathVariable int userId) {
        return handicapService.getHandicapByUserId(userId);
    }

}
