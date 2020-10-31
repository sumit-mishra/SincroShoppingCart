package com.sincro.shoppingcart.counter;

import com.sincro.shoppingcart.entity.CustomerType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingMachineTest {

  @Autowired
  DiscountCalculator discountCalculator;

  @Test
  public void should_return5000_when_purchaseAmountIs5000ForRegularCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.REGULAR, 5000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(5000d, billingAmount, 0d);
  }

  @Test
  public void should_return9500_when_purchaseAmountIs10000ForRegularCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.REGULAR, 10000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(9500d, billingAmount, 0d);
  }

  @Test
  public void should_return13500_when_purchaseAmountIs15000ForRegularCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.REGULAR, 15000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(13500d, billingAmount, 0d);
  }

  @Test
  public void should_return3600_when_purchaseAmountIs4000ForPremiumCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.PREMIUM, 4000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(3600d, billingAmount, 0d);
  }

  @Test
  public void should_return7000_when_purchaseAmountIs8000ForPremiumCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.PREMIUM, 8000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(7000d, billingAmount, 0d);
  }

  @Test
  public void should_return10200_when_purchaseAmountIs12000ForPremiumCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.PREMIUM, 12000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(10200d, billingAmount, 0d);
  }

  @Test
  public void should_return15800_when_purchaseAmountIs20000ForPremiumCustomer() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.PREMIUM, 20000d);
    ReflectionTestUtils.setField(billingMachine, "calculator", discountCalculator);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(15800d, billingAmount, 0d);
  }

}
