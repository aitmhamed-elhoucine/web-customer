package com.aitmhamed.spring.demo.DAO;
import java.util.List;

import com.aitmhamed.spring.demo.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCusomer(int theId);

	public List<Customer> searchCustomers(String theName);
}
