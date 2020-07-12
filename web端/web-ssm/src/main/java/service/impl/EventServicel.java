package service.impl;

import dao.EventMapper;
import dao.OldMapper;
import model.Event;
import model.Old;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EventService;

import java.util.List;

@Service
public class EventServicel implements EventService {
    @Autowired
    public EventMapper eventMapper;
    @Override
    public List<Event> getEventInfo() {
        return eventMapper.selectEventInfo();
    }

    @Override
    public Event getSelectEventInfo(int id) {
        return eventMapper.getSelectIDEvent(id);
    }

    @Override
    public void deleteSelectIdEvent(int id) {
        eventMapper.deleteSelectIdEvent(id);
    }
}
