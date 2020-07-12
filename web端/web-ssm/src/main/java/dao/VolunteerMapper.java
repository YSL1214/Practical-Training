package dao;

import model.Volunteer;

import java.util.List;

public interface VolunteerMapper {
    List<Volunteer> selectVolunteerInfo();

    Volunteer getSelectIDVolunteer(int id);

    void addvolunteer(Volunteer volunteer);

    void deleteSelectIdvolunteer(int id);

    void updateImg(Volunteer volunteer);

    void updatevolunteer(Volunteer volunteer);
}
