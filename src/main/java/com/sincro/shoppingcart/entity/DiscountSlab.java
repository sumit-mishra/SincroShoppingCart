package com.sincro.shoppingcart.entity;

import java.util.List;

public class DiscountSlab {

  private CustomerType type;
  private String enable;
  private List<Value> values;

  public CustomerType getType() { return type; }

  public void setType(CustomerType type) { this.type = type; }

  public String getEnable() {
    return enable;
  }

  public void setEnable(String enable) {
    this.enable = enable;
  }

  public List<Value> getValues() { return values; }

  public void setValues(List<Value> values) { this.values = values; }
}
