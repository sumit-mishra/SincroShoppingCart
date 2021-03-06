package com.sincro.shoppingcart.counter;

import com.sincro.shoppingcart.entity.CustomerType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountCalculatorTest {

  @Autowired
  DiscountCalculator calculator;

  @Test
  public void should_returnZero_when_purchaseAmountIs5000ForRegularCustomer() {
    Invoice invoice = new Invoice(CustomerType.REGULAR, 5000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(0d, discountedAmount, 0d);
  }

  @Test
  public void should_return500_when_purchaseAmountIs10000ForRegularCustomer() {
    Invoice invoice = new Invoice(CustomerType.REGULAR, 10000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(500d, discountedAmount, 0d);
  }

  @Test
  public void should_return1500_when_purchaseAmountIs15000ForRegularCustomer() {
    Invoice invoice = new Invoice(CustomerType.REGULAR, 15000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(1500d, discountedAmount, 0d);
  }

  @Test
  public void should_return400_when_purchaseAmountIs15000ForPremiumCustomer() {
    Invoice invoice = new Invoice(CustomerType.PREMIUM, 4000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(400d, discountedAmount, 0d);
  }

  @Test
  public void should_return1000_when_purchaseAmountIs8000ForPremiumCustomer() {
    Invoice invoice = new Invoice(CustomerType.PREMIUM, 8000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(1000d, discountedAmount, 0d);
  }

  @Test
  public void should_return1800_when_purchaseAmountIs12000ForPremiumCustomer() {
    Invoice invoice = new Invoice(CustomerType.PREMIUM, 12000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(1800d, discountedAmount, 0d);
  }

  @Test
  public void should_return4200_when_purchaseAmountIs20000ForPremiumCustomer() {
    Invoice invoice = new Invoice(CustomerType.PREMIUM, 20000d);
    double discountedAmount = calculator.getDiscountAmount(invoice);
    Assert.assertEquals(4200d, discountedAmount, 0d);
  }

}
