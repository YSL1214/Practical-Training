package service.impl;

import dao.OldMapper;
import model.Old;
import model.age;
import model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OldService;

import java.util.List;

@Service
public class OldServiceI implements OldService {
    @Autowired
    public OldMapper oldMapper;
    @Override
    public List<Old> getOldInfo() {
        return oldMapper.selectOldInfo();
    }

    @Override
    public Old getSelectOldInfo(int id) {
        return oldMapper.getSelectIDOld(id);
    }

    @Override
    public void addOldperson(Old old) {
        old.setOrg_id(0);
        old.setClient_id(0);
        oldMapper.addold(old);

    }

    @Override
    public void deleteSelectIdOld(int id) {
        oldMapper.deleteSelectIdOld(id);
    }

    @Override
    public void updateAddressOfPic(Integer id, String path) {
        Old old = new Old();
        old.setId(id);
        old.setImgset_dir(path);
        oldMapper.updateImg(old);
    }

    @Override
    public void updateOldperson(Old old) {
        oldMapper.updateold(old);
    }

    @Override
    public List<age> getOldNum() {
        return oldMapper.getOldNum();
    }
}
