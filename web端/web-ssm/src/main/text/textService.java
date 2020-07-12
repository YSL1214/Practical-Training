import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import model.Old;
import model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.OldService;
import service.SysUserService;


import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring-mybatis.xml"})
public class textService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OldService oldService;
//    @Test
//    public void sysUserInfoEdit() {
//        SysUser sysUser = new SysUser();
//        sysUser.setId(1);
//        sysUser.setUserName("username");
//        sysUser.setPassword("password");
//        sysUser.setSex("男");
//        sysUser.setRealName("realname");
//        sysUser.setPhone("phone");
//        sysUser.setMobile("mobile");
//        sysUser.setEmail("email");
//        sysUser.setDescription("desc");
//        sysUserService.updateSysUserInfo(sysUser);
//    }

        @Test
        public void OldInfo() {
            PageHelper.startPage(1, 10);
            List<Old> list=oldService.getOldInfo();
            PageInfo<Old> p = new PageInfo<>(list);
            System.out.println(list.size());
            System.out.println(p);
        }


}
