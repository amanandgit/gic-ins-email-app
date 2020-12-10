package com.cts.gic.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.gic.vo.Customer;

@Service
public class CustomerService {
	
	public String getCustomerDetailsforLOBandState(String LOB, String state) {
		
		//Customer customerList = findByLOBAndState(LOB, state);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(001,"Aman","Aman.Anand@cognizant.com","AUTO","AL"));
		//customerList.add(new Customer(002,"Ramesh","Ramesh.C2@cognizant.com","Property","NY"));
		//customerList.add(new Customer(003,"Gnana","GnanaSundari.M@cognizant.com","IM","NY"));
		customerList.add(new Customer(004,"Srikanth","Srikanth.M8@cognizant.com","AUTO","AL"));
		//customerList.add(new Customer(005,"Mani","Manikandan.J6@cognizant.com","WCK","AZ"));
		
		
		StringBuilder emailList = new StringBuilder();
		emailList.append("amanand92@gmail.com,");
		for(Customer customer: customerList) {
			emailList.append(customer.getEmailId()+",");
		}
		
		System.out.println(emailList.toString());
		return emailList.toString();
	}

}
