package com.geek.dao;


import com.geek.bean.Employee;

/**
 * @Author user
 * @create 2020/11/18 16:15
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer id);
}
