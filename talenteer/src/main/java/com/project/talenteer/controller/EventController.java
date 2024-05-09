package com.project.talenteer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.model.entity.Event;
import com.project.talenteer.service.EventService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getall")
	public DataResult<List<Event>> getAll(){
		return this.eventService.getAll();
	}


}
