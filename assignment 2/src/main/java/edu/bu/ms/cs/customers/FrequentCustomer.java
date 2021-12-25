package edu.bu.ms.cs.customers;

public class FrequentCustomer implements Customer {
  private final String name; // Name of customer.

  /**
   * Constructor sets frequent customer's name.
   *
   * @param name of frequent customer as String.
   */
  public FrequentCustomer(String name) {
    this.name = name;
  }

  /**
   * Gets frequent customer's name.
   *
   * @return name of frequent customer as String.
   */
  @Override
  public String getName() {
    return name;
  }
}
