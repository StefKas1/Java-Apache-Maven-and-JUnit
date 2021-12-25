package edu.bu.ms.cs.customers;

public class BusinessCustomer implements Customer {
  private String name; // Name of customer.

  /**
   * Constructor sets business customer's name.
   *
   * @param name of business customer as String.
   */
  public BusinessCustomer(String name) {
    this.name = name;
  }

  /**
   * Gets business customer's name.
   *
   * @return name of business customer as String.
   */
  @Override
  public String getName() {
    return name;
  }
}
