package service;

import model.SysUser;

public interface SysUserService {
    //登陆检验
    boolean checkLogin(String username, String password);
    //通过系统管理员用户名获取系统管理员用户
    SysUser findSysUserByName(String username);
    //注册
    void register(String username, String password,String email);

    SysUser selectByUserId(int id);

    void updateAddressOfPic(int userId,String address);

}
