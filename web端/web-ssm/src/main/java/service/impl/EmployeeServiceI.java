package service.impl;

import dao.EmployeeMapper;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceI implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmployeeInfo() {
        return employeeMapper.selectEmployeeInfo();
    }

    @Override
    public Employee getSelectEmployeeInfo(int id) {
        return employeeMapper.getSelectIDEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setOrg_id(0);
        employee.setClient_id(0);
        employeeMapper.addemployee(employee);

    }

    @Override
    public void deleteSelectIdEmployee(int id) {
        employeeMapper.deleteSelectIdEmployee(id);
    }

    @Override
    public void updateAddressOfPic(Integer id, String path) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setImgset_dir(path);
        employeeMapper.updateImg(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }
}
