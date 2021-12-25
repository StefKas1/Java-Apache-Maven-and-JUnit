package edu.bu.ms.cs.factory.emails;

import edu.bu.ms.cs.customers.Customer;

public class BusinessEmail extends Email {
  /**
   * Constructor calls parameterized super constructor and sets Customer object, email header, email
   * text, and email footer.
   *
   * @param customer containing information about customer as Customer.
   */
  public BusinessEmail(Customer customer) {
    super(customer,
        "Header BusinessEmail",
        "Text BusinessEmail",
        "Footer BusinessEmail");
  }

  /**
   * Adds unique component to email.
   *
   * @return email with unique component as String.
   */
  public String getEmail() { // Necessary for decorator.
    return super.getBaseEmail() + " - component unique to BusinessEmail";
  }
}
