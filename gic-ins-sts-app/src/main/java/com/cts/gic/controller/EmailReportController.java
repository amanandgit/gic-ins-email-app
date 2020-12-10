package com.cts.gic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gic.customer.service.CustomerService;
import com.cts.gic.email.service.SendEmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmailReportController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SendEmailService SendEmailService;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST, produces= {"application/json"})
    public String sendEmailReport(@RequestParam(value = "LOB" )String LOB,
    				@RequestParam(value = "state" )String state) {
		System.out.println("incontroller");
		String emailList = customerService.getCustomerDetailsforLOBandState(LOB, state);
		
		//get built UI from frontend using rest call
		String URL = "";
		
        return SendEmailService.sendEmailReport(emailList, URL);
    }
}
