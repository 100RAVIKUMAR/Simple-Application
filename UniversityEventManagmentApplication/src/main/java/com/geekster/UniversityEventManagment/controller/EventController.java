package com.geekster.UniversityEventManagment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.UniversityEventManagment.model.Event;
import com.geekster.UniversityEventManagment.service.EventService;

import jakarta.validation.Valid;

@RestController
public class EventController {


    @Autowired
    EventService eventService;

    @PostMapping(value = "/addeventslist")
    public String addeventslist(@Valid @RequestBody List<Event> eventlist){
        return eventService.addEvent(eventlist);
    }

    @GetMapping(value = "/geteventviadate/{date}")
    public List<Event> getAlleventsviaDate(@PathVariable("date") String date) {
        return eventService.getAllEventsByDate(date);

    }

    @DeleteMapping(value = "/deleteeventbyId/eventId/{eventId}")
    public void deleteeventbyId(@PathVariable Long eventId){
        eventService.deleteEventById(eventId);
    }


    @PutMapping(value = "/updateeventbyId/{eventId}")
    public void updateeventbyId(@PathVariable Long eventId, @Valid @RequestBody Event event){
        eventService.updateEventById(eventId,event);
    }

}
