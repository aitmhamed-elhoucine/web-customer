package com.aitmhamed.spring.demo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aitmhamed.spring.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query 
		Query<Customer> thequery=currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> listCustomers= thequery.getResultList();
		
		return listCustomers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theCustomer);
		
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer =currentSession.get(Customer.class, theId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCusomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from Customer where id =:theCustomerId");
		query.setParameter("theCustomerId", theId);
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theName) {
         Session currentSession = sessionFactory.getCurrentSession();
         Query<Customer> thequery=currentSession.createQuery("from Customer where lower(firstName) like:theFirstName or lower(lastName) like:theFirstName", Customer.class);
         thequery.setParameter("theFirstName", "%" + theName.toLowerCase() + "%");
         List<Customer> listCustomers= thequery.getResultList();
		return listCustomers;
	}

}
