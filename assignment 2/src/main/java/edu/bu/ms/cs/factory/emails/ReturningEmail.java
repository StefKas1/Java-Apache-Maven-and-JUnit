package edu.bu.ms.cs.factory.emails;

import edu.bu.ms.cs.customers.Customer;

public class ReturningEmail extends Email {
  /**
   * Constructor calls parameterized super constructor and sets Customer object, email header, email
   * text, and email footer.
   *
   * @param customer containing information about customer as Customer.
   */
  public ReturningEmail(Customer customer) {
    super(customer,
        "Header ReturningEmail",
        "Text ReturningEmail",
        "Footer ReturningEmail");
  }

  /**
   * Adds unique component to email.
   *
   * @return email with unique component as String.
   */
  public String getEmail() { // Necessary for decorator.
    return super.getBaseEmail() + " - component unique to ReturningEmail";
  }
}
