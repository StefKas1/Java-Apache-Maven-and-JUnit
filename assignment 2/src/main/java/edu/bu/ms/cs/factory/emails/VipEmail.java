package edu.bu.ms.cs.factory.emails;

import edu.bu.ms.cs.customers.Customer;

public class VipEmail extends Email {
  /**
   * Constructor calls parameterized super constructor and sets Customer object, email header, email
   * text, and email footer.
   *
   * @param customer containing information about customer as Customer.
   */
  public VipEmail(Customer customer) {
    super(customer,
        "Header VipEmail",
        "Text VipEmail",
        "Footer VipEmail");
  }

  /**
   * Adds unique component to email.
   *
   * @return email with unique component as String.
   */
  public String getEmail() { // Necessary for decorator.
    return super.getBaseEmail() + " - component unique to VipEmail";
  }
}
