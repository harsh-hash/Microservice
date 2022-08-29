package com.infosys.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.com.entity.Customer;
import com.infosys.com.repository.CustomerRepository;

@Service
public class RegistrationService {

	@Autowired
	private CustomerRepository customerRepository;

	public Boolean insertUser(Customer customer) throws InfyGoServiceException {

		Customer cust = customerRepository.saveAndFlush(customer);

		if (cust == null) {
			throw new Exception("User not found");
		} else {
			return true;
		}

	}

}
