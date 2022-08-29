package com.infosys.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.com.dto.LoginDetails;
import com.infosys.com.entity.Customer;
import com.infosys.com.repository.CustomerRepository;

@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	public boolean isUserValid(LoginDetails customerLogin) throws InfyGoServiceException {

		Customer customer = customerRepository.findById(customerLogin.getUserId()).get();

		if (customer == null) {
			throw new Exception("User not found");
		} else if (!(customer.getPassword().equals(customerLogin.getPassword()))) {
			throw new Exception("Invalid credentials");
		}
		return true;

	}

}
