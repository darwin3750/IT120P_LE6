package com.medel.employee.Impl;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
  public static void main(String[] args) {

    Endpoint.publish("http://localhost:50000/employee", new EmployeeImpl());
  }
}