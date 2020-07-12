package dao;

import model.SysUser;

public interface SysUserMapper {
    SysUser selectBySysUsername(String username);

    void register(SysUser sysUser);

    SysUser selectBySysUserID(int id);

    void updateLogo(SysUser sysUser);

    void updateInfo(SysUser sysUser);
}
