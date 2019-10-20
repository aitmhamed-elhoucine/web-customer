package com.aitmhamed.spring.demo.service;

import java.util.List;

import com.aitmhamed.spring.demo.entity.Customer;

public interface CustomerService {
   public List<Customer> getCustomers();

public void saveCustomer(Customer theCustomer);

public Customer getCustomer(int theId);

public void deleteCustomer(int theId);

public List<Customer> searchCustomers(String theName);
}
