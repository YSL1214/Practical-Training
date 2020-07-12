package service;

import model.Event;
import model.Old;
import model.age;

import java.util.List;

public interface EventService {
    List<Event> getEventInfo();

    Event getSelectEventInfo(int id);


    void deleteSelectIdEvent(int id);

}
