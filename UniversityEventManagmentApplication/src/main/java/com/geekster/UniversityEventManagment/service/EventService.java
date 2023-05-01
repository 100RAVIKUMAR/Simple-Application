package com.geekster.UniversityEventManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.UniversityEventManagment.repo.EventDao;
import com.geekster.UniversityEventManagment.model.Event;

import jakarta.validation.Valid;

@Service
public class EventService {

    @Autowired
    EventDao eventRepo;

    public String addEvent(List<Event> eventlist) {
       Iterable<Event>list= eventRepo.saveAll(eventlist);
       if(list!=null){
           return "Saved Successfully..";
       }
       return "Not Saved Eventlist..!!!";
    }

    public List<Event> getAllEventsByDate(String date) {
        return eventRepo.findByDate(date);
    }

    public void deleteEventById(Long eventId) {
        eventRepo.deleteById(eventId);
    }

    public void updateEventById(Long eventId, @Valid Event event) {
        eventRepo.save(event);
    }
}