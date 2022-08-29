package com.infosys.com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDITCARD_DETAILS")
public class CreditCardDetails {
	@Id
	private String cardNumber;
	private String cardHolderName;
	private String apin;
	private String cvv;
	private String expiryMonth;
	private String expiryYear;
	private String totalBill;

	public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getApin() {
        return apin;
    }

    public void setApin(String apin) {
        this.apin = apin;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "CreditCardDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", apin='" + apin + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expiryMonth='" + expiryMonth + '\'' +
                ", expiryYear='" + expiryYear + '\'' +
                ", totalBill='" + totalBill + '\'' +
                '}';
    }
	

}
