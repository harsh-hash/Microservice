package com.infosys.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.com.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String> {

}
