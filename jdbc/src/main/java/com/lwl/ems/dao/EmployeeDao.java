package com.lwl.ems.dao;

import java.util.List;

import com.lwl.ems.domain.Dept;
import com.lwl.ems.domain.Employee;
import com.lwl.ems.dto.SalStat;

public interface EmployeeDao {

	List<Employee> getEmployeeByDept(int deptno);

	List<Employee> maxSalaryEmployees();

	Dept getDeptWhichHasMaxNumberOfEmployee();

	List<Employee> getEmployeesWithManagers();

	SalStat getSalStatOfOrganization();

	SalStat getSalStatOfDept(int deptno);

	List<String> allManagerNames();

	List<Employee> whoJoinDayIs(String dayName);

	int addEmployees(List<Employee> list);

	int addDepartements(List<Dept> list);

	int addEmployee(Employee emp);

	int addDepartement(Dept dept);

	boolean deleteEmployee(int empno);

	boolean deleteDept(int deptno);

	int updateEmployee(Employee emp);

	int updateDept(Dept dept);

	Employee getEmpByEmpno(int empno);

	Dept getDeptByDeptno(int deptno);

}
