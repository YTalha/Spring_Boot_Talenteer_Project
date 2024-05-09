package com.project.talenteer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.talenteer.core.utilities.result.DataResult;
import com.project.talenteer.core.utilities.result.SuccessDataResult;
import com.project.talenteer.model.entity.Event;
import com.project.talenteer.repository.EventRepository;
import com.project.talenteer.service.EventService;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @Override
    public DataResult<List<Event>> getAll() {
        return new SuccessDataResult<List<Event>>(this.eventRepository.findAll(), "Data Listelendi");
    }

}
