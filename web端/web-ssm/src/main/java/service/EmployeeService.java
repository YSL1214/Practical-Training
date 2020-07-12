package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeInfo();

    Employee getSelectEmployeeInfo(int id);

    void addEmployee(Employee employee);

    void deleteSelectIdEmployee(int id);

    void updateAddressOfPic(Integer valueOf, String path);

    void updateEmployee(Employee employee);
}
