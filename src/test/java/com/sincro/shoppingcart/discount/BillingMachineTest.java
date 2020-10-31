package com.sincro.shoppingcart.discount;

import com.sincro.shoppingcart.counter.BillingMachine;
import com.sincro.shoppingcart.entity.CustomerType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingMachineTest {

  @Test
  public void test() {
    BillingMachine billingMachine = new BillingMachine(CustomerType.REGULAR, 5000d);
    double billingAmount = billingMachine.getBillingAmount();
    Assert.assertEquals(5000d, billingAmount, 0d);
  }
}
