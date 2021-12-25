package edu.bu.ms.cs.customers;

public class NewCustomer implements Customer {
  private final String name; // Name of customer.

  /**
   * Constructor sets new customer's name.
   *
   * @param name of new customer as String.
   */
  public NewCustomer(String name) {
    this.name = name;
  }

  /**
   * Gets new customer's name.
   *
   * @return name of new customer as String.
   */
  @Override
  public String getName() {
    return name;
  }
}
