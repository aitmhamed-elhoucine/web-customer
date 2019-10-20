package com.aitmhamed.spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aitmhamed.spring.demo.DAO.CustomerDAO;
import com.aitmhamed.spring.demo.entity.Customer;
import com.aitmhamed.spring.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
      
	 //need to inject customer service
	 @Autowired
	 private CustomerService customerService;
	
	  @GetMapping("/listCustomers")
	  public String listCustomers(Model theModel) {
		  
		  //get customers from dao 
		  List<Customer> customers = customerService.getCustomers();
		  //add customers to model 
		  theModel.addAttribute("customer", customers);
		  return "list-customers";
	  }
	  
	  @GetMapping("/showFormForAdd")
	  public String showFormForAdd(Model theModel) {
		  
		  //create model attribute to bind form data 
		  Customer customer= new Customer();
		  
		  theModel.addAttribute("customer",customer);
		  
		  return "customer-form";
	  }
	  
	  @PostMapping("/saveCustomer")
	  public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult bindingResult) {
		  if(bindingResult.hasErrors()) {
			  return "customer-form";
		  }
		  else {
			  customerService.saveCustomer(theCustomer);
			  return "redirect:/customer/listCustomers";
		  }
		  
	  }
	  
	  @GetMapping("showFormForUpdate")
	  public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		  
		  Customer theCustomer = customerService.getCustomer(theId);
		  System.out.println(theCustomer.getFirstName());
		  theModel.addAttribute("customer", theCustomer);
		  
		  return "customer-form";
	  }
	  
	  @GetMapping("/delete")
	  public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {
		  
		  customerService.deleteCustomer(theId);
		  
		  return "redirect:/customer/listCustomers";
		  
	  }
	  @PostMapping("/search")
	  public String searchByName(@RequestParam("theSearchName") String theName, Model theModel) {
		  
          List<Customer> theCustomers = customerService.searchCustomers(theName);
          
          theModel.addAttribute("customer", theCustomers);
		  
		  return "list-customers";
	  }
}
