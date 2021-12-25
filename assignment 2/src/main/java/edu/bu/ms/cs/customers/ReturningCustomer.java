package edu.bu.ms.cs.customers;

public class ReturningCustomer implements Customer {
  private final String name; // Name of customer.

  /**
   * Constructor sets returning customer's name.
   *
   * @param name of returning customer as String.
   */
  public ReturningCustomer(String name) {
    this.name = name;
  }

  /**
   * Gets returning customer's name.
   *
   * @return name of returning customer as String.
   */
  @Override
  public String getName() {
    return name;
  }
}
