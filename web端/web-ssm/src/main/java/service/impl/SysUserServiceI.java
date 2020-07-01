package service.impl;

import dao.SysUserMapper;
import model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SysUserService;

@Service
public class SysUserServiceI implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean checkLogin(String username, String password) {
        SysUser sysUser = findSysUserByName(username);
        if (sysUser != null) {
            return password.equals(sysUser.getPassword());
        }
        return false;
    }

    @Override
    public SysUser findSysUserByName(String username) {
        return sysUserMapper.selectBySysUsername(username);
    }


    @Override
    public void register(String username, String password,String email) {
        SysUser sysUser = new SysUser();
        sysUser.setOrg_id(0);
        sysUser.setClient_id(0);
        sysUser.setUserName(username);
        sysUser.setPassword(password);
        sysUser.setEmail(email);
        sysUserMapper.register(sysUser);
    }

    @Override
    public SysUser selectByUserId(int id) {
        return null;
    }

    @Override
    public void updateAddressOfPic(int userId, String address) {

    }
}
