package service;

import model.Volunteer;

import java.util.List;

public interface VolunteerService {
    List<Volunteer> getVolunteerInfo();

    Volunteer getSelectVolunteerInfo(int id);

    void addVolunteer(Volunteer volunteer);

    void deleteSelectIdVolunteer(int id);

    void updateAddressOfPic(Integer valueOf, String path);

    void updateVolunteer(Volunteer volunteer);
}
