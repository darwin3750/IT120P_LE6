package com.medel.employee.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.medel.employee.fx.Employee;
import com.medel.employee.fx.EmployeeFx;

@WebService(endpointInterface = "com.medel.employee.fx.EmployeeFx")
public class EmployeeImpl implements EmployeeFx {
  Map<String, Employee> employees = new HashMap<String, Employee>();

  @Override
  public Employee getEmployeeDetails(String id) {
    if (employees.containsKey(id))
      return employees.get(id);
    return new Employee();
  }

  @Override
  public String createEmployee(Employee employee) {
    try {
      employees.put(employee.getId(), employee);
      return "success";
    } catch (Exception e) {
      return "error";
    }
  }

  @Override
  public Employee[] getAllEmployees() {
    ArrayList<Employee> emps = new ArrayList<Employee>();
    Employee emp = null;

    for (Map.Entry<String, Employee> e : employees.entrySet()) {
      emp = new Employee();
      emp.setId(e.getKey());
      emp.setName(e.getValue().getName());
      emps.add(emp);
    }
    return (Employee[]) emps.toArray(new Employee[emps.size()]);
  }

  @Override
  public String deleteEmployee(String id) {
    try {
      if (employees.containsKey(id)) {
        employees.remove(id);
        return "success";
      }
      return "employee not found";
    } catch (Exception e) {
      return "error";
    }
  }

  @Override
  public String updateEmployee(String id, Employee employee) {
    try {
      if (employees.containsKey(id)) {
        employees.remove(id);
        createEmployee(employee);
        return "success";
      }
      return "employee not found";
    } catch (Exception e) {
      return "error";
    }
  }
}