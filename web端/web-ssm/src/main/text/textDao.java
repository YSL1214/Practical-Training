import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import dao.*;
import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.EmployeeService;
import service.SysUserService;
import service.VolunteerService;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring-mybatis.xml"})
public class textDao {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private OldMapper oldMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VolunteerService volunteerService;




//    List<Employee> selectEmployeeInfo();
//
//    Employee getSelectIDEmployee(int id);
//
//    void addemployee(Employee employee);
//
//    void deleteSelectIdEmployee(int id);
//
//    void updateImg(Employee employee);
//
//    void updateEmployee(Employee employee);

//    @Test
//    public void employee() {
////        List<Employee> list = employeeMapper.selectEmployeeInfo();
////        for (Employee employee : list) {
////            System.out.println(employee.getId());
////        }
//
////        Employee employee = employeeMapper.getSelectIDEmployee(1);
////        System.out.println(employee.getUserName());
//
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setAge(40);
//        employee.setDESCRIPTION("强");
//        employee.setGender("女");
//        employee.setUserName("工作人员2");
//        employee.setPhone("8612341234");
////        employeeService.addEmployee(employee);
//
////        employeeService.deleteSelectIdEmployee(60);
//        employeeService.updateEmployee(employee);
//
//
//    }

        @Test
    public void volunteer() {
//        List<Volunteer> list = volunteerService.getVolunteerInfo();
//        for (Volunteer volunteer : list) {
//            System.out.println(volunteer.getId());
//        }

//        Volunteer volunteer = volunteerService.getSelectVolunteerInfo(1);
//        System.out.println(volunteer.getUserName());

        Volunteer employee = new Volunteer();
        employee.setId(1);
        employee.setAge(40);
        employee.setDESCRIPTION("强");
        employee.setGender("女");
        employee.setUserName("义工2");
        employee.setPhone("18612341234");
//        volunteerService.addVolunteer(employee);

//       volunteerService.deleteSelectIdVolunteer(60);
        volunteerService.updateVolunteer(employee);


    }


//    @Test
//    public void login() {
//        System.out.println(sysUserMapper.selectBySysUsername("admin").getPassword());
//        System.out.println(sysUserService.findSysUserByName("admin").getPassword());
//    System.out.println(sysUserService.checkLogin("admin","admin"));
//        System.out.println(sysUserMapper.selectBySysUserID(1).getPassword());
//    }

//    @Test
//    public void old() {
//        List<Old> list = oldMapper.selectOldInfo();
//        PageInfo<Old> p = new PageInfo<>(list);
//        String json = "{\"code\":0,\"msg\":\"\",\"count\":"+list.size()+",\"data\":";
//        System.out.println( json = json+ JSON.toJSONString(p.getList())+"}");
//
//
//
//    }


}
