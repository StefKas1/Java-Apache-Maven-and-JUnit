package edu.bu.ms.cs.customers;

public class VipCustomer implements Customer {
  private final String name; // Name of customer.

  /**
   * Constructor sets VIP customer's name.
   *
   * @param name of VIP customer as String.
   */
  public VipCustomer(String name) {
    this.name = name;
  }

  /**
   * Gets VIP customer's name.
   *
   * @return name of VIP customer as String.
   */
  @Override
  public String getName() {
    return name;
  }
}
