package com.sincro.shoppingcart.counter;

import com.sincro.shoppingcart.entity.CustomerType;
import com.sincro.shoppingcart.entity.DiscountSlab;
import com.sincro.shoppingcart.entity.Value;
import com.sincro.shoppingcart.util.YamlPropertySource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Optional;

@Configuration
@ConfigurationProperties(prefix = "customer-type-discount")
@PropertySource(value = "classpath:discount.yml", factory = YamlPropertySource.class)
public class DiscountCalculator {

  private static final double DEFAULT_DISCOUNT = 0.0d;
  private String enable;
  private List<DiscountSlab> discountSlabs;

  public double getDiscountAmount(final Invoice invoice) {
    final Optional<DiscountSlab> discountSlab = getDiscountSlabByCustomerType(invoice.getCustomerType());
    double totalDiscount = DEFAULT_DISCOUNT;
    if (discountSlab.isPresent()) {
      DiscountSlab slab = discountSlab.get();
      List<Value> purchaseValues = slab.getValues();
      totalDiscount = purchaseValues.stream()
          .mapToDouble(discountDetails -> calculateDiscount(discountDetails, invoice.getPurchaseAmount())).sum();
    }
    return totalDiscount;
  }

  private Optional<DiscountSlab> getDiscountSlabByCustomerType(final CustomerType customerType) {
    return discountSlabs.stream().filter(discountSlab -> customerType == discountSlab.getType()).findAny();
  }

  private double calculateDiscount(final Value discountDetails, final double purchaseAmount) {
    final int discountPercentage = discountDetails.getDiscountPercentage();
    double applicableAmount = 0.0d;
    if (discountPercentage > 0) {
      int fromAmount = discountDetails.getFromAmount();
      int toAmount = discountDetails.getToAmount();
      if (purchaseAmount >= toAmount) {
        applicableAmount = toAmount - fromAmount;
      } else if (purchaseAmount > fromAmount) {
        applicableAmount = purchaseAmount - fromAmount;
      }
    }
    return (applicableAmount * discountPercentage) / 100d;
  }

  public String getEnable() {
    return enable;
  }

  public void setEnable(String enable) {
    this.enable = enable;
  }

  public List<DiscountSlab> getDiscountSlabs() {
    return discountSlabs;
  }

  public void setDiscountSlabs(List<DiscountSlab> discountSlabs) {
    this.discountSlabs = discountSlabs;
  }
}
