package com.sincro.shoppingcart.entity;

public class Value {
  private int fromAmount;
  private int toAmount;
  private int discountPercentage;

  public int getFromAmount() {
    return fromAmount;
  }

  public void setFromAmount(int fromAmount) {
    this.fromAmount = fromAmount;
  }

  public int getToAmount() {
    return toAmount;
  }

  public void setToAmount(int toAmount) {
    this.toAmount = toAmount;
  }

  public int getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(int discountPercentage) {
    this.discountPercentage = discountPercentage;
  }
}
