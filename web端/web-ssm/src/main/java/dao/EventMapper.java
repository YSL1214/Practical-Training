package dao;

import model.Old;
import model.age;
import model.Event;

import java.util.List;

public interface EventMapper {
    List<Event> selectEventInfo();

    Event getSelectIDEvent(int id);

    void deleteSelectIdEvent(int id);

}
