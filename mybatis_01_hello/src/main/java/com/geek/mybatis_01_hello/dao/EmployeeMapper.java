package com.geek.mybatis_01_hello.dao;

import com.geek.mybatis_01_hello.domain.Employee;

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
