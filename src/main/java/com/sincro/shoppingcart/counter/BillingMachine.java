package com.sincro.shoppingcart.counter;

import com.sincro.shoppingcart.entity.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;

public class BillingMachine {

  private CustomerType customerType;
  private double purchaseAmount;

  @Autowired
  DiscountCalculator calculator;

  public BillingMachine(CustomerType customerType, double purchaseAmount) {
    this.customerType = customerType;
    this.purchaseAmount = purchaseAmount;
  }

  public double getBillingAmount() {
    return (purchaseAmount - calculator.getDiscountAmount(this));
  }

  public CustomerType getCustomerType() {
    return customerType;
  }

  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }

  public double getPurchaseAmount() {
    return purchaseAmount;
  }

  public void setPurchaseAmount(double purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }
}
