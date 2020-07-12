package service.impl;


import dao.EmployeeMapper;
import dao.VolunteerMapper;
import model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.VolunteerService;

import java.util.List;

@Service
public class VolunteerServiceI implements VolunteerService {
    @Autowired
    private VolunteerMapper volunteerMapper;
    @Override
    public List<Volunteer> getVolunteerInfo() {
        return volunteerMapper.selectVolunteerInfo();
    }

    @Override
    public Volunteer getSelectVolunteerInfo(int id) {
        return volunteerMapper.getSelectIDVolunteer(id);
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        volunteer.setOrg_id(0);
        volunteer.setClient_id(0);
        volunteerMapper.addvolunteer(volunteer);
    }

    @Override
    public void deleteSelectIdVolunteer(int id) {
        volunteerMapper.deleteSelectIdvolunteer(id);
    }

    @Override
    public void updateAddressOfPic(Integer id, String path) {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(id);
        volunteer.setImgset_dir(path);
        volunteerMapper.updateImg(volunteer);
    }

    @Override
    public void updateVolunteer(Volunteer volunteer) {
        volunteerMapper.updatevolunteer(volunteer);
    }
}
