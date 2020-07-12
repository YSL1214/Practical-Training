package dao;

import model.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeInfo();

    Employee getSelectIDEmployee(int id);

    void addemployee(Employee employee);

    void deleteSelectIdEmployee(int id);

    void updateImg(Employee employee);

    void updateEmployee(Employee employee);
}
