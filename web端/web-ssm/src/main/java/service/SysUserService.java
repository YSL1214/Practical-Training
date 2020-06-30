package service;

import model.SysUser;

public interface SysUserService {
    boolean checkLogin(String username, String password);

    SysUser findSysUserByName(String username);

    void register(String username, String password);

    SysUser selectByUserId(int id);

    void updateAddressOfPic(int userId,String address);

}
