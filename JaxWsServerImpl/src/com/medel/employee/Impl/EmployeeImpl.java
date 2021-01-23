package com.medel.employee.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.medel.employee.fx.Employee;
import com.medel.employee.fx.EmployeeFx;

@WebService(endpointInterface = "com.medel.employee.fx.EmployeeFx")
public class EmployeeImpl implements EmployeeFx {
  Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

  @Override
  public Employee getEmployeeDetails(int id) {
    if (employees.containsKey(id))
      return employees.get(id);
    return new Employee();
  }

  @Override
  public String createEmployee(Employee employee) {
    try {
      if (employees.containsKey(employee.getId())) {
        return "That ID already exists!";
      }else{
        employees.put(employee.getId(), employee);
        return "Add success!";
      }
    } catch (Exception e) {
      return "Add error!";
    }
  }

  @Override
  public Employee[] getAllEmployees() {
    ArrayList<Employee> emps = new ArrayList<Employee>();
    Employee emp = null;

    for (Map.Entry<Integer, Employee> e : employees.entrySet()) {
      emp = new Employee();
      emp.setId(e.getKey());
      emp.setName(e.getValue().getName());
      emps.add(emp);
    }
    return (Employee[]) emps.toArray(new Employee[emps.size()]);
  }

  @Override
  public String deleteEmployee(int id) {
    try {
      if (employees.containsKey(id)) {
        employees.remove(id);
        return "Delete success!";
      }
      return "Employee not found!";
    } catch (Exception e) {
      return "Delete error!";
    }
  }

  @Override
  public String updateEmployee(int id, Employee employee) {
    try {
      if (employees.containsKey(id)) {
        employees.remove(id);
        createEmployee(employee);
        return "Update success!";
      }
      return "Employee not found!";
    } catch (Exception e) {
      return "Update error!";
    }
  }
}