package com.medel.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.medel.employee.fx.Employee;
import com.medel.employee.fx.EmployeeFx;

public class Client {

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub
    URL url = new URL("http://localhost:50000/employee?wsdl");
    QName qname = new QName("http://Impl.employee.medel.com/", "EmployeeImplService");
    Service service = Service.create(url, qname);

    EmployeeFx employee = service.getPort(EmployeeFx.class);

    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Paul");
    emp.setEmployeeNumber(111111);
    employee.createEmployee(emp);
    
    emp.setId(2);
    emp.setName("Paula");
    emp.setEmployeeNumber(222222);
    employee.createEmployee(emp);

    System.out.println(employee.getEmployeeDetails(1).getName() + " " + employee.getEmployeeDetails(1).getEmployeeNumber());
    System.out.println(employee.getEmployeeDetails(2).getName() + " " + employee.getEmployeeDetails(2).getEmployeeNumber());

	}

}
