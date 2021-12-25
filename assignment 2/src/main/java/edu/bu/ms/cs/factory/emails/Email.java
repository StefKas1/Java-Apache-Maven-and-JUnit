package edu.bu.ms.cs.factory.emails;

import edu.bu.ms.cs.customers.Customer;

public abstract class Email {
  private String header;
  private String text;
  private String footer;
  private Customer customer;

  /**
   * Default constructor.
   */
  public Email() {
  }

  /**
   * Constructor sets Customer object, email header, email text, and email footer.
   *
   * @param customer containing information about customer as Customer.
   * @param header   header as String.
   * @param text     main content as String.
   * @param footer   footer as String.
   */
  public Email(Customer customer, String header, String text, String footer) {
    this.customer = customer;
    this.header = header;
    this.text = text;
    this.footer = footer;
  }

  public abstract String getEmail(); // Necessary for decorator.

  /**
   * Builds String which contains base email information.
   *
   * @return base email as String.
   */
  public String getBaseEmail() {
    return "Email{"
        + "customerName='" + customer.getName() + '\''
        + ", header='" + header + '\''
        + ", text='" + text + '\''
        + ", footer='" + footer + '\''
        + '}';
  }
}
