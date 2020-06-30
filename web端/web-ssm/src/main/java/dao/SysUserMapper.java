package dao;

import model.SysUser;

public interface SysUserMapper {
    SysUser selectBySysUsername(String username);
}
